package com.nguyenthanhhau.itstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.detaiproducts.DePhone;

@Repository
public interface DePhoneRepository extends JpaRepository<DePhone, Long>{

}
