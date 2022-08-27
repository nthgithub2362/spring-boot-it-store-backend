package com.nguyenthanhhau.itstore.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query(value="SELECT * FROM category where category.id=?1 ", nativeQuery = true)
	public Category CategoryPr(Long id);
	@Query(value="SELECT * FROM category where category.id_parent=0", nativeQuery = true)
	public List<Category>  listHome();
	@Query(value="SELECT * FROM category where category.id_parent=13", nativeQuery = true)
	public List<Category> Cp();
	@Query(value="SELECT * FROM category where category.id_parent=14", nativeQuery = true)
	public List<Category> Cl();
	@Query(value="SELECT * FROM category where category.id_parent=30", nativeQuery = true)
	public List<Category> Cb();
	@Query(value="SELECT * FROM category where category.id_parent=17", nativeQuery = true)
	public List<Category> Cs();
	@Query(value="SELECT * FROM category where category.id_parent=16", nativeQuery = true)
	public List<Category> Cm();
	@Query(value="SELECT * FROM category where category.id_parent=15", nativeQuery = true)
	public List<Category> Ck();

	

}
