package org.example.creational.builder;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private Person(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder {
        private String lastName;
        private String firstName;
        private int age;

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Person build(){
            return new  Person(this);
        }
    }
}
