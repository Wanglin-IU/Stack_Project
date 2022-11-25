package com.example.spring.Map;

import com.example.spring.Bean.Label_F_Lower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("Lower")
public interface Label_F extends JpaRepository<Label_F_Lower, Integer> {
}
