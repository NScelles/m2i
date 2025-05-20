package org.example.creational.builder;

public class House {

    private int floor;
    private boolean pool;
    private String roofType;
    private String color;

    @Override
    public String toString() {
        return "House{" +
                "floor=" + floor +
                ", pool=" + pool +
                ", roofType='" + roofType + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    private House(Builder builder) {
        this.floor = builder.floor;
        this.pool = builder.pool;
        this.roofType = builder.roofType;
        this.color = builder.color;
    }

    public static class Builder {

        public int floor;
        public boolean pool;
        public String roofType;
        public String color;

        public Builder floor(int floor){
            this.floor = floor;
            return this;
        }

        public Builder pool(boolean pool){
            this.pool = pool;
            return this;
        }

        public Builder roofType(String roofType){
            this.roofType = roofType;
            return this;
        }

        public Builder color(String color){
            this.color = color;
            return this;
        }

        public House build(){
            return new House(this);
        }
    }
}
