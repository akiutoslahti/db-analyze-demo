package dbdemo.domain;

public class TextLength {

    private final int withSpaces;
    private final int withoutSpaces;

    public TextLength(String text) {
        withSpaces = text.length();
        withoutSpaces = countLengthWithoutWhiteSpace(text);
    }

    public int getWithSpaces() {
        return withSpaces;
    }

    public int getWithoutSpaces() {
        return withoutSpaces;
    }

    private int countLengthWithoutWhiteSpace(String text) {
        int whiteSpaceCount = 0;
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                whiteSpaceCount++;
            }
        }
        return text.length() - whiteSpaceCount;
    }

}
