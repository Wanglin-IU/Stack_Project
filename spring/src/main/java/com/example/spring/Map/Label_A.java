package com.example.spring.Map;

import com.example.spring.Bean.Label_A_All;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("All")
public interface Label_A extends JpaRepository<Label_A_All, Integer> {
}
