package dbdemo.domain;

public class AnalyzeRequest {

    private String text;

    public void setText(String text) {
        this.text = text.toLowerCase();
    }

    public String getText() {
        return text;
    }

}
