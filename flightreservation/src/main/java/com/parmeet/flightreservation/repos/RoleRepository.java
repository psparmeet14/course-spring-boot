package com.parmeet.flightreservation.repos;

import com.parmeet.flightreservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
