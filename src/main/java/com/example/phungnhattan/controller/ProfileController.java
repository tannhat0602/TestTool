package com.example.phungnhattan.controller;

import com.example.phungnhattan.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/")
    public String index(Model model) {
        Map<String, Object> data = profileService.getProfileData();
        data.forEach(model::addAttribute);
        return "index";
    }
}
