package org.example.structural.decorator.text;

public class UpperCaseDecorator extends TextDecorator {

    public UpperCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform(String input) {
        return super.transform(input).toUpperCase();
    }
}
