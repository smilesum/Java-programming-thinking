package src.main.java.com.Java.enum_19;

import src.main.java.com.Java.generics_15.Generator;
import java.util.Random;

//Java don't support multi-inherit
//So we consider implement multi-api
enum cartoonCharater implements Generator<cartoonCharater> {
  NUTTY,BOB;
  private Random random = new Random(11);
  public cartoonCharater next() {
    return values()[random.nextInt(cartoonCharater.values().length)];
  }
}
