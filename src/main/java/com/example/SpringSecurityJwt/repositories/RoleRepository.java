package com.example.SpringSecurityJwt.repositories;

import com.example.SpringSecurityJwt.models.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
