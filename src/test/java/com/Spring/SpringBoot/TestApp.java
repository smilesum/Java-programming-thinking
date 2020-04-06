package test.java.com.Spring.SpringBoot;

import static org.junit.Assert.assertEquals;

import main.java.com.Spring.SpringBoot.App;
import org.junit.Test;

/**
 * Tests for correct dependency retrieval with maven rules.
 */
public class TestApp {

  @Test
  public void testCompare() throws Exception {
    App app = new App();
    assertEquals("should return 0 when both numbers are equal", 0, app.compare(1, 1));
    System.out.println("11111111");
  }

}