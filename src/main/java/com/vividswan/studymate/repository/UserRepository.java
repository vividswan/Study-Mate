package com.vividswan.studymate.repository;

import com.vividswan.studymate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
