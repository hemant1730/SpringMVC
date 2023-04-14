package com.jspiders.springmvcflat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvcflat.pojo.FlatPojo;
import com.jspiders.springmvcflat.repository.FlatRepository;

@Service
public class FlatService {
	
	@Autowired
	private FlatRepository repository;
	
	public FlatPojo addFlat(String name, String email, long contact, String city, double rent) {
		FlatPojo flat = repository.addFlat(name, email, contact, city, rent);
		return flat;
	}

	public FlatPojo search(int id) {
		FlatPojo flat = repository.searchFlat(id);
		return flat;
	}

	public List<FlatPojo> searchAllFlats() {
		List<FlatPojo> flats = repository.searchAllFlats();
		return flats;
	}

	public void removeFlat(int id) {
		repository.removeFlat(id);
	}

	public FlatPojo updateFlat(int id, String name, String email, long contact, String city,
			double rent) {
		FlatPojo flat = repository.updateFlat(id, name, email, contact, city, rent);
		return flat;
	}

}
