package dev.midnightcoder.midnightshift.users.repository;

import dev.midnightcoder.midnightshift.users.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}