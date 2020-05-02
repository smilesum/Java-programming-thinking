## Operation
### Intermdediate operation

Stateless | Stateful
---|---
unordered | distinct
filter | sorted
map | limit
mapToInt | skip
mapToLong | 
mapToDouble | 
flatMap | 
peek |

### Terminal Operation

non-short-circuting | short-circuting
---|---
forEach | row 1 col 2
toArray | row 2 col 2
reduce | anyMatch()
collect | allMatch()
max | noneMatch
min | findFirst
count | FindAny

###### non-short-cicuting
    Have to process each elemment to return result.
    
###### short-circtuin
    Dont' need to process each element to return the result.
    
## Implement

### Relationship between Intermediate operation with Terminal operation

    The intermediate opration just one mark, 
    only the terminal opration that can triger the execution. 
    Once meet terminal operation,  will trace back the previous stage one by one. 
    Then the process will be executed from top to down. 

### How to define one operation
    one compleate operation consists of:
     <data source, operation, callback function>
    Stream use the concept of "stage" to describe one complete operation.
    And, stream comibne all stage together by their order.
    just like the picture below.

[link](https://github.com/CarpenterLee/JavaLambdaInternals/blob/master/Figures/Stream_pipeline_example.png/)

### Api of every sink(or stage)
1. void begin(long size):  before traverse element. Nocify the sink to make preparation.
2. void end(): After the traverse elemens. notify the sink that there are no more element.
3. boolean cancellationRequested(): whether can terminate the execution, for terminal short-circuting by early.
4. void accept(T t): Be used in the prcess  of traversing elements and handling the element.The preverious stage just need to the next stages's accept function

code example

```java
// Stream.sort()方法用到的Sink实现
class RefSortingSink<T> extends AbstractRefSortingSink<T> {
    private ArrayList<T> list;// 存放用于排序的元素
    RefSortingSink(Sink<? super T> downstream, Comparator<? super T> comparator) {
        super(downstream, comparator);
    }
    @Override
    public void begin(long size) {
        ...
        // 创建一个存放排序元素的列表
        list = (size >= 0) ? new ArrayList<T>((int) size) : new ArrayList<T>();
    }
    @Override
    public void end() {
        list.sort(comparator);// 只有元素全部接收之后才能开始排序
        downstream.begin(list.size());
        if (!cancellationWasRequested) {// 下游Sink不包含短路操作
            list.forEach(downstream::accept);// 2. 将处理结果传递给流水线下游的Sink
        }
        else {// 下游Sink包含短路操作
            for (T t : list) {// 每次都调用cancellationRequested()询问是否可以结束处理。
                if (downstream.cancellationRequested()) break;
                downstream.accept(t);// 2. 将处理结果传递给流水线下游的Sink
            }
        }
        downstream.end();
        list = null;
    }
    @Override
    public void accept(T t) {
        list.add(t);// 1. 使用当前Sink包装动作处理t，只是简单的将元素添加到中间列表当中
    }
}

1. 首先begin()方法告诉Sink参与排序的元素个数，方便确定中间结果容器的的大小；
1. 之后通过accept()方法将元素添加到中间结果当中，最终执行时调用者会不断调用该方法，直到遍历所有元素；
1. 最后end()方法告诉Sink所有元素遍历完毕，启动排序步骤，排序完成后将结果传递给下游的Sink；
1. 如果下游的Sink是短路操作，将结果传递给下游时不断询问下游cancellationRequested()是否可以结束处理。
```

## Parallel Stream


```java
IntStream intStream = IntStream.range(0, 10);
Set<Thread> threadSet = new HashSet<>();
intStream.parallel().forEach(i -> {
  Thread thread = Thread.currentThread();
  threadSet.add(thread);
});
threadSet.stream().distinct().forEach(System.out::println);

//
/*
Output:
Thread[ForkJoinPool.commonPool-worker-23,5,main]
Thread[ForkJoinPool.commonPool-worker-5,5,main]
Thread[ForkJoinPool.commonPool-worker-27,5,main]
Thread[ForkJoinPool.commonPool-worker-31,5,main]
Thread[ForkJoinPool.commonPool-worker-9,5,main]
Thread[main,5,main]
Thread[ForkJoinPool.commonPool-worker-19,5,main]
*/
```

Attention:  multi stream will use the same one thread pool. So don't use I/O operation in parallel stream.(Otherwise will block other parallel stream)
