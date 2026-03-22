package com.vcube.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.mobile.model.Mobile;
import com.vcube.mobile.repo.Mobilerepo;

@Service
public class Mobileservice {

	@Autowired
	Mobilerepo mrepo;

	public Mobile getmobilename(String mobilename) {
		return mrepo.mobilename(mobilename);
	}

	public Mobile saveMobile(Mobile mobile) {
		return mrepo.save(mobile);
	}

	public List<Mobile> getAllMobiles() {
		return mrepo.findAll();
	}

	public Mobile getMobileById(int id) {
		return mrepo.findById(id).orElse(null);
	}

	public void deleteMobile(int id) {
		mrepo.deleteById(id);
	}

	public List<Mobile> findHighRamCapacityList(int ram) {

		return mrepo.findByRam(ram);

	}

}
