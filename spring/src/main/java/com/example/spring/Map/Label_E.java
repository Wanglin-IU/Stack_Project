package com.example.spring.Map;

import com.example.spring.Bean.Label_E_SMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("SMonth")
public interface Label_E extends JpaRepository<Label_E_SMonth, Integer> {
}
