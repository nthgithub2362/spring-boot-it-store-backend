package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.New;
import com.nguyenthanhhau.itstore.entity.Product;

@Repository
public interface NewRepository extends JpaRepository<New, Long>{
	@Query(value="SELECT * FROM new where new.type='phone' limit 3", nativeQuery = true)
	public List<New> listNewPhone();
	
	@Query(value="SELECT * FROM new where new.type='laptop' limit 3", nativeQuery = true)
	public List<New> listLap();
	
	@Query(value="SELECT * FROM new where new.type='watch' limit 3", nativeQuery = true)
	public List<New> listWatc();
	
	@Query(value="SELECT * FROM new where id=(SELECT max(id) FROM new where new.type!='promotion' and new.type!='tips' )", nativeQuery = true)
	public New newHlight();
	@Query(value="SELECT * FROM new where new.type!='promotion' and new.type != 'tips' limit 5", nativeQuery = true)
	public List<New> listnewHlight();
	
	@Query(value="SELECT * FROM new where new.type!='promotion' and new.type != 'tips' ORDER BY id DESC limit 5", nativeQuery = true)
	public List<New> listnewRight();
	
	@Query(value="SELECT * FROM new where new.type='promotion' ORDER BY id DESC limit 5", nativeQuery = true)
	public List<New> listnewPro();
	
	@Query(value="SELECT * FROM new where new.type='tips' ORDER BY id DESC limit 3", nativeQuery = true)
	public List<New> listTips();
}
