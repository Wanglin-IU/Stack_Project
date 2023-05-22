package com.example.spring.Controller;

import com.example.spring.Bean.*;
import com.example.spring.Map.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //代表返回的是json格式的数据
@RequestMapping("/")
//注入多个接口
public class StackController {

    @Resource(name = "All")
    private Label_A label_a;

    @GetMapping("/all")
    public List<Label_A_All> all() {
        return label_a.findAll();
    }

    @Resource(name = "Top")
    private Label_B label_b;

    @GetMapping("/top")
    public List<Label_B_Top> tops() {
        return label_b.findAll();
    }

    @Resource(name = "Random")
    private Label_C label_c;

    @GetMapping("/random")
    public List<Label_C_Random> randoms() {
        return label_c.findAll();
    }

    @Resource(name = "Compare")
    private Label_D label_d;

    @GetMapping("/compare")
    public List<Label_D_Compare> compares() {
        return label_d.findAll();
    }

    @Resource(name = "SMonth")
    private Label_E label_e;

    @RequestMapping("/smonth")
    public List<Label_E_SMonth> sMonths() {
        return label_e.findAll();
    }

    @Resource(name = "Lower")
    private Label_F label_f;

    @GetMapping("/lower")
    public List<Label_F_Lower> lowers() {
        return label_f.findAll();
    }
}