package com.usman.practice.hibernate.entity;

import javax.persistence.*;

@Table(name = "categories")
@Entity
public class Category {
//    `id`,`type`,`description`
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;

    public Category() {
    }

    public Category(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
