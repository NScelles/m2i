package org.example.structural.decorator.text;

public class ChangeTextDecorator extends TextDecorator{

    private String newText;

    public ChangeTextDecorator(Text text,String newText) {
        super(text);
        this.newText = newText;
    }

    @Override
    public String transform() {
        this.text.setText(newText);
        return super.transform();
    }

    @Override
    public String getText() {
        return super.getText();
    }
}
