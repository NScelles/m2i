package org.example.structural.decorator.text;

public class PlainText implements Text{

    protected String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String transform() {
        return text;
    }
}
