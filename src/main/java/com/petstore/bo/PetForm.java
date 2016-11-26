package com.petstore.bo;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * Created by iakoupov on 2016-11-26.
 */
public class PetForm {

    private Pet pet;

    private MultipartFile[] files;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "PetForm{" +
                "pet=" + pet +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
