package org.example.structural.decorator.text;

public class PlainText implements Text{

    private String input;

    public PlainText(String input) {
        this.input = input;
    }

    @Override
    public String transform() {
        return input;
    }

    @Override
    public String getText() {
        return input;
    }

    @Override
    public void setText(String newText) {
        this.input = newText;
    }


}
