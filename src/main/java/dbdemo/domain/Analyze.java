package dbdemo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Analyze {

    private final TextLength textLength;
    private int wordCount;
    private final List<Entry<Character, Integer>> characterCount;

    public Analyze(String text) {
        String textToAnalyze = text.toLowerCase();

        textLength = new TextLength(textToAnalyze);
        wordCount = 0;
        characterCount = new ArrayList<>();

        analyzeText(textToAnalyze);
    }

    public TextLength getTextLength() {
        return textLength;
    }

    public int getWordCount() {
        return wordCount;
    }

    public List<Entry<Character, Integer>> getCharacterCount() {
        return characterCount;
    }

    private void analyzeText(String textToAnalyze) {
        countWords(textToAnalyze);
        countCharacters(textToAnalyze);
    }

    private void countWords(String textToAnalyze) {
        boolean onWord = false;
        for (char c : textToAnalyze.toCharArray()) {
            if ((Character.isAlphabetic(c) || Character.isDigit(c)) && !onWord) {
                onWord = true;
                wordCount++;
            } else if (Character.isWhitespace(c) && onWord) {
                onWord = false;
            }
        }
    }

    private void countCharacters(String textToAnalyze) {
        Map<Character, Integer> tempCounts = new TreeMap<>();
        for (char c : textToAnalyze.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (!tempCounts.containsKey(c)) {
                    tempCounts.put(c, 0);
                }
                tempCounts.replace(c, tempCounts.get(c) + 1);
            }
        }
        for (Entry<Character, Integer> e : tempCounts.entrySet()) {
            characterCount.add(e);
        }
        System.out.println(characterCount);
    }

}
