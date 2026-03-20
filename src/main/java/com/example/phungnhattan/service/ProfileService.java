package com.example.phungnhattan.service;

import com.example.phungnhattan.entity.*;
import com.example.phungnhattan.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final EducationRepository educationRepository;
    private final LanguageRepository languageRepository;

    @Transactional(readOnly = true)
    public Map<String, Object> getProfileData() {
        Profile profile = profileRepository.findFirstByOrderByIdAsc();
        if (profile == null) return Collections.emptyMap();

        Long pid = profile.getId();
        List<Skill> skills = skillRepository.findByProfileIdOrderBySortOrderAsc(pid);
        List<Project> projects = projectRepository.findByProfileIdOrderBySortOrderAsc(pid);
        List<Education> educations = educationRepository.findByProfileId(pid);
        List<Language> languages = languageRepository.findByProfileId(pid);

        // Group skills by category, preserving insertion order
        Map<String, List<String>> skillsByCategory = new LinkedHashMap<>();
        for (Skill skill : skills) {
            skillsByCategory
                .computeIfAbsent(skill.getCategory(), k -> new ArrayList<>())
                .add(skill.getName());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("profile", profile);
        data.put("skillsByCategory", skillsByCategory);
        data.put("projects", projects);
        data.put("educations", educations);
        data.put("languages", languages);
        return data;
    }
}
