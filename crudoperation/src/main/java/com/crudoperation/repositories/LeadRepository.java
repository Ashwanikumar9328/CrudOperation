package com.crudoperation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudoperation.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}

