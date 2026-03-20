package com.example.phungnhattan.config;

import com.example.phungnhattan.entity.*;
import com.example.phungnhattan.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProfileRepository profileRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final EducationRepository educationRepository;
    private final LanguageRepository languageRepository;

    @Override
    public void run(String... args) {
        if (profileRepository.count() > 0) return;

        // Profile
        Profile profile = profileRepository.save(new Profile(
            "Phung Nhat Tan",
            "Backend Developer Intern",
            "phungnhattan060204@gmail.com",
            "+84 389413351",
            "109 ThaiHoa, DongNai",
            "github.com/tannhat0602",
            "Final-year IT student specializing in backend development with Java and Spring Boot. " +
            "Experienced in building RESTful APIs, implementing JWT authentication, and designing " +
            "scalable backend systems using layered architecture and SOLID principles."
        ));

        Long pid = profile.getId();

        // Skills
        int order = 0;
        for (String name : List.of("Java", "C#")) {
            skillRepository.save(new Skill(pid, "Programming Languages", name, order++));
        }
        for (String name : List.of("Spring Boot", "ASP.NET Core MVC")) {
            skillRepository.save(new Skill(pid, "Frameworks", name, order++));
        }
        for (String name : List.of("SQL Server", "MySQL")) {
            skillRepository.save(new Skill(pid, "Database", name, order++));
        }
        for (String name : List.of(
            "RESTful API Design",
            "Layered Architecture (Controller \u2013 Service \u2013 Repository)",
            "DTO Pattern",
            "Validation & Global Exception Handling",
            "Dependency Injection",
            "JPA / Hibernate",
            "HTTP Status Codes"
        )) {
            skillRepository.save(new Skill(pid, "Core Knowledge", name, order++));
        }
        for (String name : List.of("Git", "Postman", "Maven", "Docker")) {
            skillRepository.save(new Skill(pid, "Tools", name, order++));
        }

        // Projects
        Project project1 = new Project(pid, "Task Management REST API",
            "Java | Spring Boot | Spring Security | Spring Data JPA | SQL Server", 1);
        project1.setBullets(List.of(
            "Built RESTful APIs for task management (CRUD operations)",
            "Implemented JWT authentication and role-based authorization",
            "Applied layered architecture (Controller \u2013 Service \u2013 Repository)",
            "Implemented pagination and filtering for task listing APIs",
            "Documented APIs using Swagger / OpenAPI",
            "Wrote unit tests with JUnit & Mockito and containerized with Docker"
        ));
        projectRepository.save(project1);

        Project project2 = new Project(pid, "CommuneX Web Application",
            "C# | ASP.NET Core | Microsoft SQL Server", 2);
        project2.setBullets(List.of(
            "Developed web application using MVC architecture",
            "Implemented Dependency Injection for loose coupling",
            "Used Entity Framework Core for database access",
            "Integrated real-time communication using SignalR"
        ));
        projectRepository.save(project2);

        // Education
        educationRepository.save(new Education(pid,
            "Bachelor of Information Technology",
            "Ho Chi Minh University of Technology (HUTECH)",
            "Expected Graduation: 2026"
        ));

        // Languages
        languageRepository.save(new Language(pid, "English", "Intermediate"));
        languageRepository.save(new Language(pid, "Vietnamese", "Native"));
    }
}
