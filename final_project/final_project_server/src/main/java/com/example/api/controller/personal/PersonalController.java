package com.example.api.controller.personal;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/personal")
public class PersonalController {

    @GetMapping("/get")
    public String getProducts() {
        return "Personal get";
    }

    @PostMapping
    public String post() {
        return "Personal post";
    }

    @PutMapping
    public String put() {
        return "Personal put";
    }
}
