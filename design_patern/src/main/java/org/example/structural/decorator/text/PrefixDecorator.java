package org.example.structural.decorator.text;

public class PrefixDecorator extends TextDecorator{

    private String prefix;

    public PrefixDecorator(Text text,String prefix) {
        super(text);
        this.prefix = prefix;
    }

    @Override
    public String transform() {
        return this.prefix + super.transform();
    }

    @Override
    public String getText() {
        return super.getText();
    }
}
