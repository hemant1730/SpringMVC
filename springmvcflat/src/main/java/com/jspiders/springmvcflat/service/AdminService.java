package com.jspiders.springmvcflat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvcflat.pojo.AdminPojo;
import com.jspiders.springmvcflat.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;

	public AdminPojo login(String username, String password) {
		AdminPojo admin = repository.login(username, password);
		return admin;
	}

	public AdminPojo addAdmin(String username, String password) {
		AdminPojo admin = repository.addAdmin(username, password);
		return admin;
	}

}
