package org.example;


public class Human implements Comparable<Human> {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null)
            throw new NullPointerException();
        this.name = name;
    }

    @Override
    public int compareTo(Human anotherHuman) {
        return getName().length() - anotherHuman.getName().length();
    }
}