package com.ferbator.shelterapi.dao.entities;

import com.ferbator.shelterapi.dao.dto.CatDto;
import com.ferbator.shelterapi.dao.enums.Colors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cats")
public class Cat {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "birthday")
    private Timestamp birthday;
    @Basic
    @Column(name = "breed")
    private String breed;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Colors color;

    public Cat(CatDto cat) {
        this.name = cat.getName();
        this.color = cat.getColor();
        this.breed = cat.getBreed();
        this.birthday = cat.getBirthday();
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(id, cat.id)
                && Objects.equals(name, cat.name)
                && Objects.equals(birthday, cat.birthday)
                && Objects.equals(breed, cat.breed)
                && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, breed, id, color);
    }
}
