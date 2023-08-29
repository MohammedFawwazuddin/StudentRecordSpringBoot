package com.prodapt.learningspring;

public class Student {
    private Long id;
    private int rank;
    private String name;
    private int marks;

    public Student() {
    }

    public Student(Long id, int rank, String name, int marks) {
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.marks = marks;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

