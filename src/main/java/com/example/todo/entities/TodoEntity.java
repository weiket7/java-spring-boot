package com.example.todo.entities;

import javax.persistence.*;

@Entity
@Table(name = "Todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Long Id;

    @Column(name = "Name")
    public String Name;

    public TodoEntity() {

    }

    public TodoEntity(String name) {
        this.Name = name;
    }
}
