package com.example.serwissamochodyback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Return the name of the login page template
    }

}
