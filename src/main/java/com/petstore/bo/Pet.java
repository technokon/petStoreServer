package com.petstore.bo;

import org.springframework.data.annotation.Id;

/**
 * Created by iakoupov on 2016-11-24.
 */
public class Pet {

    @Id
    private String id;

    private String name;

    private String description;

    private String motto;

    private String image;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", motto='" + motto + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
