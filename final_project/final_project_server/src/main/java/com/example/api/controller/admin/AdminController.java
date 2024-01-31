package com.example.api.controller.admin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {

    @GetMapping
    public String get() {
        return "Admin get";
    }

    @PostMapping
    public String post() {
        return "Admin post";
    }

    @PutMapping
    public String put() {
        return "Admin put";
    }
}
