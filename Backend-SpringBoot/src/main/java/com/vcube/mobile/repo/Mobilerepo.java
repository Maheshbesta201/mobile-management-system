package com.vcube.mobile.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vcube.mobile.model.Mobile;

public interface Mobilerepo extends JpaRepository<Mobile, Integer> {

	Mobile mobilename(String mobilename);

	 @Query("SELECT m FROM Mobile m WHERE m.ram >= :ram")
	    List<Mobile> findByRam(@Param("ram") int ram);

}
