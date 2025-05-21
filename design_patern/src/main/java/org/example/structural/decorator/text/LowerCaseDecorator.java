package org.example.structural.decorator.text;

public class LowerCaseDecorator extends TextDecorator{

    public LowerCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform(String input) {
        return super.transform(input).toLowerCase();
    }
}

