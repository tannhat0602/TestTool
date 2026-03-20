package com.example.phungnhattan.repository;

import com.example.phungnhattan.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findByProfileId(Long profileId);
}
