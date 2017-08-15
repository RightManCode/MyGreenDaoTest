package com.example.admin.mygreendaotest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by admin on 2017/8/15.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;

    private String name;

    private int age;

    private String interests;

    private String phoneNumber;

    @Generated(hash = 586692638)
    public User() {
    }

    @Generated(hash = 907044812)
    public User(Long id, String name, int age, String interests, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.interests = interests;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
