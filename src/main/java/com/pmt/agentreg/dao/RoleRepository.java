package com.pmt.agentreg.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmt.agentreg.model.RoleName;
import com.pmt.agentreg.model.SystemRole;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<SystemRole, Long> {

//	Optional<SystemRole> findByName(RoleName  rolename);

}
