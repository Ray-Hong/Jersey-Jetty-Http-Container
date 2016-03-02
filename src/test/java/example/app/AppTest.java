package example.app;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
/**
 * Unit tests.
 **/
public class AppTest {
    @Test
    public void testHelloWorld() throws Exception {
        App app = new App();

        URL appUri = new URL("http://localhost:8080/test/hello");

        HttpURLConnection appGet = (HttpURLConnection) appUri.openConnection();
        app.start();
        assertThat(appGet.getResponseCode()).isEqualTo(200);
        app.stop();
    }
}
