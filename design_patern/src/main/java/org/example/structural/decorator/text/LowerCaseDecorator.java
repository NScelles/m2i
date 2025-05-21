package org.example.structural.decorator.text;

public class LowerCaseDecorator extends TextDecorator{

    public LowerCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform().toLowerCase();
    }

    @Override
    public String getText() {
        return super.getText();
    }
}

