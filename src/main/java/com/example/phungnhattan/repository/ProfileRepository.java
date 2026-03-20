package com.example.phungnhattan.repository;

import com.example.phungnhattan.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findFirstByOrderByIdAsc();
}
