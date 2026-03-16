package dev.midnightcoder.midnightshift.users.repository;

import dev.midnightcoder.midnightshift.users.domain.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeoLocationRepository extends JpaRepository<GeoLocation, UUID> {
}