package com.example.spring.Map;

import com.example.spring.Bean.Label_B_Top;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("Top")
public interface Label_B extends JpaRepository<Label_B_Top, Integer> {
}
