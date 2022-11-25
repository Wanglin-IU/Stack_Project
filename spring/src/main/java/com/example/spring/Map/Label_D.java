package com.example.spring.Map;

import com.example.spring.Bean.Label_D_Compare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("Compare")
public interface Label_D extends JpaRepository<Label_D_Compare, Integer> {
}
