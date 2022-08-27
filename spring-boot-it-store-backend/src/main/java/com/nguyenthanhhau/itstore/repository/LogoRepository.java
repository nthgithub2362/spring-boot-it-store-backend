package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.logo.Logo;
@Repository
public interface LogoRepository extends JpaRepository<Logo, Long> {
	@Query(value="SELECT * FROM logo where logo.name='phone'", nativeQuery = true)
	public List<Logo> listLogoPhone();
	@Query(value="SELECT * FROM logo where logo.name='laptop'", nativeQuery = true)
	public List<Logo> listLogoLaptop();
	@Query(value="SELECT * FROM logo where logo.name='watch'", nativeQuery = true)
	public List<Logo> listLogoWatch();
	@Query(value="SELECT * FROM logo where logo.name='accessorie'", nativeQuery = true)
	public List<Logo> listLogoAccess();
}
