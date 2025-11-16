package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetails {

    //annotate the class as entity and map it to db table

    //define the fields

    //annotate the field with db table name

    //create constructor

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtube='" + youtube + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public InstructorDetails(String youtube, String hobby) {
        this.youtube = youtube;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    //generate getters/setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    private String youtube;

    @Column(name="hobby")
    private String hobby;

    public InstructorDetails(){}
}


