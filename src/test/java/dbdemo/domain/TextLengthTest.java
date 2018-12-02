package dbdemo.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextLengthTest {

    private static final String TEST_TEXT = "Hello analyze!";
    
    @Test 
    public void newTextLengthTest() {
        TextLength textLength = new TextLength(TEST_TEXT);
        assertEquals(TEST_TEXT.length(), textLength.getWithSpaces());
        assertEquals(withoutWhiteSpace(TEST_TEXT).length(), textLength.getWithoutSpaces());
    }
    
    private String withoutWhiteSpace(String text) {
        String ret = "";
        for (char c : text.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                ret += c;
            }
        }
        return ret;
    }
    
}
