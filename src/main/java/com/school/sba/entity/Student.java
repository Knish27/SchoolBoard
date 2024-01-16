package com.school.sba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int studId;
@Column(unique = true)
private String studName;
@Column(unique = true)
private String studEmail;
private long studContNo;
}
