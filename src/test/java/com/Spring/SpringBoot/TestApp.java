package src.test.java.com.Spring.SpringBoot;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.main.java.com.Spring.SpringBoot.App;


public class TestApp {
  @Test
  public void testCompare() throws Exception {
    App app = new App();
    assertEquals("should return 0 when both numbers are equal", 0, app.compare(1, 1));
    System.out.println(2);
  }
}
