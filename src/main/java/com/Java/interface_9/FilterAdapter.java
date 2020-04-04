package src.main.java.com.Java.interface_9;

public class FilterAdapter implements Processor {
  Filter filter;
  public FilterAdapter(Filter filter) {
    this.filter =  filter;
  }
  public String name() {
    return filter.name();
  }
  public Wavefrom process(Object o) {
    return filter.process((Wavefrom) o);
  }
}
