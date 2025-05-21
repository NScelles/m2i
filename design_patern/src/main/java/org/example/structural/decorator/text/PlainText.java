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
}
