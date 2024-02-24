package javaCore.prac1;

import java.util.ArrayList;
import java.util.List;

class MyStringBuilder22 {
    private StringBuilder stringBuilder;
    private List<String> snapShot;
    private int currentIndex;

    public MyStringBuilder22() {
        this.stringBuilder = new StringBuilder();
        this.snapShot = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void append(String str) {
        stringBuilder.append(str);
        currentIndex++;
        saveSnapShot();
    }

    private void saveSnapShot() {
        snapShot.add(stringBuilder.toString());
    }

    public void undo() {
        if (currentIndex > 0) {
            stringBuilder = new StringBuilder(snapShot.get(currentIndex - 1));
            currentIndex--;
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyStringBuilder22 myStringBuilder22 = new MyStringBuilder22();

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.append("ПРивет");
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);

        myStringBuilder22.undo();
        System.out.println(myStringBuilder22);


    }
}
