package com.wybudujemydom.wd.repository;

import com.wybudujemydom.wd.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
    UserRole getByName(String role);

    Optional<Object> findByName(String role);
}
