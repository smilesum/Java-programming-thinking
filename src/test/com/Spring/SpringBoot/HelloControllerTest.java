package src.test.com.Spring.SpringBoot;

import java.net.URL;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

  @LocalServerPort
  private int port;//will based in WebEnvironment.RANG_PORT
  private URL url;

  @Autowired
  private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws Exception {
    this.url = new URL("http://localhost:" + port + "/");
  }

  @Test
  public void sayHello() {
    ResponseEntity<String> responses = template.getForEntity(url.toString(), String.class);
    Assertions.assertEquals("hello, world", responses.getBody());
  }
}
