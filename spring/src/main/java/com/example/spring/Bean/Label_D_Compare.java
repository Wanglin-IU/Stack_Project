package com.example.spring.Bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Label_D_Compare {
    @Id
    private String tag_name;
    private int total_count;
}
