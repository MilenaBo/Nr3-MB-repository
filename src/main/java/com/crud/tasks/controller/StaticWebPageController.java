package com.crud.tasks.controller;
// 32.1
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {
    @RequestMapping("/")
    public  String index(Map<String, Object> model) {
        model.put("variable","My Thymeleaf variable");
        model.put("one", 1);
        model.put("two", 2);
        model.put("suma", " + ");
        model.put("iloczyn"," * ");
        model.put("wynik", " = ");
        model.put("minus", " - ");
        return "index";
    }
}
