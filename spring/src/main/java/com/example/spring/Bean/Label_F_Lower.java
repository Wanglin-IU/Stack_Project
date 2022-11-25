package com.example.spring.Bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Label_F_Lower {
    @Id
    private String tag_name;
    private int tag_count;
}
