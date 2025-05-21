package org.example.structural.decorator.text;

public abstract class TextDecorator implements Text{

    protected Text text;

    public TextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String transform() {
        return text.transform();
    }

    @Override
    public String getText() {
        return text.getText();
    }

    @Override
    public void setText(String newText) {
        text.setText(newText);
    }

}
