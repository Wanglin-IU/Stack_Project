package com.example.spring.Bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Label_E_SMonth {
    @Id
    private int post_count;
    private String tag_name;
    private String year_month;
}
