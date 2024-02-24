package javaCore.prac1;

import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        MyStringBuilder myStringBuilder = new MyStringBuilder(new StringBuilder());
        Memory memory = new Memory(myStringBuilder);

        myStringBuilder.append("1");
        memory.backup();
        System.out.println(myStringBuilder);
        myStringBuilder.append("2");
        memory.backup();
        System.out.println(myStringBuilder);
        myStringBuilder.append("3");
        System.out.println(myStringBuilder);

        memory.undo();

        System.out.println(myStringBuilder);

        memory.undo();

        System.out.println(myStringBuilder);

        memory.undo();

        System.out.println(myStringBuilder);
    }
}

class Memento {
    private StringBuilder stringBuilder;

    public Memento(StringBuilder stringBuilder) {
        this.stringBuilder = new StringBuilder(stringBuilder);
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}

class MyStringBuilder {
    private StringBuilder stringBuilder;

        public MyStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = new StringBuilder(stringBuilder);
    }

    public String toString() {
        return "String: " + stringBuilder.toString();
    }

    public Memento save() {
        return new Memento(new StringBuilder(stringBuilder));
    }

    public void append(String str) {
        stringBuilder.append(str);
    }

    public void restore(Memento memento) {
        stringBuilder = memento.getStringBuilder();
    }
}

class Memory {
    private Stack<Memento> history;
    MyStringBuilder myStringBuilder;

    public Memory(MyStringBuilder myStringBuilder) {
        this.myStringBuilder = myStringBuilder;
        history = new Stack<>();
    }

    public void backup() {
        history.push(myStringBuilder.save());
    }

    public void undo() {
        if (history.isEmpty()) return;
        myStringBuilder.restore(history.pop());
    }
}


