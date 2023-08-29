package com.crudoperation.services;

import java.util.List;

import com.crudoperation.entities.Lead;

public interface LeadService {
	
	public void saveOneLead(Lead lead);

	public List<Lead> getAllleads();

	public void deleteLead(long id);

	public Lead updateLead(long id);

	public Lead getLeadById(long id);
}

