package dbdemo.domain;

public class TextLength {

    private int withSpaces;
    private int withoutSpaces;

    public TextLength(String text) {
        withSpaces = text.length();
        withoutSpaces = lengthWithoutWhiteSpace(text);
    }

    public int getWithSpaces() {
        return withSpaces;
    }

    public int getWithoutSpaces() {
        return withoutSpaces;
    }

    private int lengthWithoutWhiteSpace(String text) {
        int whiteSpaceCount = 0;
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                whiteSpaceCount++;
            }
        }
        return text.length() - whiteSpaceCount;
    }

}
