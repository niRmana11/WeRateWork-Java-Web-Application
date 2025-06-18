package com.weratework.weratework.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

@Id
    @GeneratedValue
    private int id;
@Column(nullable = false, unique = true)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
