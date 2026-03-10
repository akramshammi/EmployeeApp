package com.assessment2.assessment2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    private int id;

    private String name;
    private String email;
    private String course;
    private double marks;

    @Lob
    private byte[] profileImage;

    @Lob
    private byte[] assignmentFile;
}