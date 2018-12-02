package dbdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest(properties = "server.port=8080",
        classes = DbDemoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplicationTest {

    private HttpClient httpClient;
    private HttpPost httpPost;
    private String testJsonString = "{\"text\": \"hello 2 times  \"}";

    @Before
    public void setUp() {
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost("http://localhost:8080/analyze");
        HttpEntity stringEntity = new StringEntity(testJsonString, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
    }

    @Test
    public void testAnalyzeRouteReturns200() {
        try {
            HttpResponse response = httpClient.execute(httpPost);
            assertEquals(200, response.getStatusLine().getStatusCode());
        } catch (IOException ioe) {
            fail();
        }
    }

    @Test
    public void testAnalyzeRouteReturnsJson() {
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            assertEquals("application/json;charset=UTF-8", entity.getContentType().getValue());
        } catch (IOException ioe) {
            fail();
        }
    }

    @Test
    public void testAnalyzeRouteReturnExpectedResponse() {
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String actualResponse = EntityUtils.toString(entity, "UTF-8");
            String expectedResponseString
                    = "{"
                    + "\"textLength\":{\"withSpaces\":15,\"withoutSpaces\":11},"
                    + "\"wordCount\":3,"
                    + "\"characterCount\":[{\"e\":2},{\"h\":1},{\"i\":1},{\"l\":2},{\"m\":1},{\"o\":1},{\"s\":1},{\"t\":1}]"
                    + "}";
            assertEquals(expectedResponseString, actualResponse);
        } catch (IOException ioe) {
            fail();
        }
    }

}
