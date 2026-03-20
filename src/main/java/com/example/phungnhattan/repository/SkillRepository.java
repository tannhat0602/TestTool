package com.example.phungnhattan.repository;

import com.example.phungnhattan.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByProfileIdOrderBySortOrderAsc(Long profileId);
}
