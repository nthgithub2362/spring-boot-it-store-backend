package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nguyenthanhhau.itstore.entity.Contact;
import com.nguyenthanhhau.itstore.entity.New;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	@Query(value="SELECT * FROM contact ORDER BY id DESC limit 4", nativeQuery = true)
	public List<Contact> listContactNew();
}
