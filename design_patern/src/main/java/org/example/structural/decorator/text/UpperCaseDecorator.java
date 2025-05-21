package org.example.structural.decorator.text;

public class UpperCaseDecorator extends TextDecorator {

    public UpperCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform().toUpperCase();
    }

    @Override
    public String getText() {
        return super.getText();
    }
}
