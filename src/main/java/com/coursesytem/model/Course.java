package com.coursesytem.model;

// An course
public class Course {

    private static final int MAX_CAPACITY = 30;

    private String name;
    private int credit;
    private int curCapacity;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
        curCapacity = 0;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public int getCurrentCapacity() {
        return curCapacity;
    }

}
