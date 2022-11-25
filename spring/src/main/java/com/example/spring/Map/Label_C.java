package com.example.spring.Map;

import com.example.spring.Bean.Label_C_Random;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("Random")
public interface Label_C extends JpaRepository<Label_C_Random, Integer> {
}
