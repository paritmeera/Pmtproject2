package com.pmt.agentreg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.agentreg.domain.PackageDomain;

public interface PackageRepository extends JpaRepository<PackageDomain, Integer> {

}
