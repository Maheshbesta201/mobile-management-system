package com.vcube.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.mobile.model.Mobile;
import com.vcube.mobile.service.Mobileservice;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/mobiles")
public class MobileController {

    @Autowired
    private Mobileservice service;

    // GET all mobiles
    @GetMapping("/Getmobiles")
    public List<Mobile> getAllMobiles() {
        return service.getAllMobiles();
    }

    // ADD mobile
    @PostMapping
    public Mobile saveMobile(@RequestBody Mobile mobile) {
        return service.saveMobile(mobile);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteMobile(@PathVariable int id) {
        service.deleteMobile(id);
        return "Deleted Successfully";
    }

    // GET by ID (for edit)
    @GetMapping("/{id}")
    public Mobile getMobile(@PathVariable int id) {
        return service.getMobileById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Mobile updateMobile(@PathVariable int id, @RequestBody Mobile mobile) {
        return service.saveMobile(mobile);
    }

    // FILTER RAM
    @GetMapping("/ram/{ram}")
    public List<Mobile> getHighRam(@PathVariable int ram) {
        return service.findHighRamCapacityList(ram);
    }
}