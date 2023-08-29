package com.crudoperation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperation.entities.Lead;
import com.crudoperation.repositories.LeadRepository;

@Service // business logic done in service layer
public class LeadServiceimpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllleads() {
      List<Lead> leads = leadRepo.findAll();
		
		return leads;
	}

	@Override
	public void deleteLead(long id) {
      leadRepo.deleteById(id);		
	}

	@Override
	public Lead updateLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
        Lead lead = findById.get();	
		return lead;
	}
	
	@Override
	public Lead getLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
