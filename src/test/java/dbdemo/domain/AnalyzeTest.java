package dbdemo.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Before;
import org.junit.Test;

public class AnalyzeTest {

    private Analyze analyze;
    private static final String TEST_TEXT = "hello 2 times  ";

    @Before
    public void setUp() {
        analyze = new Analyze(TEST_TEXT);
    }

    @Test
    public void textLengthTest() {
        TextLength textLength = analyze.getTextLength();
        assertNotNull(textLength);
        assertEquals(15, textLength.getWithSpaces());
        assertEquals(11, textLength.getWithoutSpaces());
    }

    @Test
    public void getWordCountTest() {
        assertEquals(3, analyze.getWordCount());
    }

    @Test
    public void getCharacterCountTest() {
        Map<Character, Integer> expectedCharacterCounts = getExpectedCharacterCounts();
        List<Entry<Character, Integer>> actualCharacterCounts = analyze.getCharacterCount();
        for (Entry<Character, Integer> e : actualCharacterCounts) {
            assertEquals(expectedCharacterCounts.get(e.getKey()), e.getValue());
        }
    }

    private Map<Character, Integer> getExpectedCharacterCounts() {
        Map<Character, Integer> expectedCharacterCounts = new HashMap<>();
        expectedCharacterCounts.put('e', 2);
        expectedCharacterCounts.put('h', 1);
        expectedCharacterCounts.put('i', 1);
        expectedCharacterCounts.put('l', 2);
        expectedCharacterCounts.put('m', 1);
        expectedCharacterCounts.put('o', 1);
        expectedCharacterCounts.put('s', 1);
        expectedCharacterCounts.put('t', 1);
        return expectedCharacterCounts;
    }

}
