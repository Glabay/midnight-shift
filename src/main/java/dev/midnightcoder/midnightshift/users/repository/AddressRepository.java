package dev.midnightcoder.midnightshift.users.repository;

import dev.midnightcoder.midnightshift.users.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}