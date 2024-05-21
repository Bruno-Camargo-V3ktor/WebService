package dev.v3ktor.webservice.model.repository;

import dev.v3ktor.webservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
