package dbdemo.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AnalyzeRequestTest {

    public static String TEST_STRING = "Hello analyze!";

    @Test
    public void setGetTest() {
        AnalyzeRequest analyzeReq = new AnalyzeRequest();
        assertNull(analyzeReq.getText());
        analyzeReq.setText(TEST_STRING);
        assertEquals(TEST_STRING, analyzeReq.getText());
    }

}
