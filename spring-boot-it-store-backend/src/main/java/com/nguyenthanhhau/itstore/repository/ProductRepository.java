package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query(value="SELECT * FROM product LEFT JOIN product_relateds ON (product.id = product_relateds.product_id) where product_relateds.product_re=?1 ", nativeQuery = true)
	public List<Product> listProductRelated(Long id);
	@Query(value="SELECT * FROM product LEFT JOIN order_detail ON (product.id = order_detail.id) where order_detail.id_order=?1 ", nativeQuery = true)
	public List<Product> listProductOrder(String id);
	
	@Query(value="SELECT * FROM product where product.cateid=1 ", nativeQuery = true)
	public List<Product> listPhone();
	
	@Query(value="SELECT * FROM product where product.cateid=2 ", nativeQuery = true)
	public List<Product> listLap();
	
	@Query(value="SELECT * FROM product where product.cateid=3 ", nativeQuery = true)
	public List<Product> listWatc();
	
	@Query("SELECT p FROM Product p WHERE CONCAT(LOWER(p.name),LOWER(p.brand)) LIKE %?1%")
	List<Product> findByNameContainsIgnoreCase(String keyword);
	
	@Query("SELECT p FROM Product p WHERE CONCAT(LOWER(p.name),p.brand) LIKE %?1%")
	public List<Product> search(String keyword);
	
	@Query(value="SELECT * FROM product where product.price_net>0 ", nativeQuery = true)
	public List<Product> listSale();
	
	@Query(value="SELECT * FROM product where product.cateid=4 ", nativeQuery = true)
	public List<Product> listAccessories();
	
	@Query(value="SELECT * FROM product where product.price_net>0 limit 8", nativeQuery = true)
	public List<Product> listOfNew();
	
	@Query(value="SELECT * FROM product where product.title='phone'", nativeQuery = true)
	public List<Product> listByWith();

	@Query(value="SELECT * FROM product where product.title='laptop'", nativeQuery = true)
	public List<Product> listLapByWith();
	
	//filter
	@Query("SELECT p FROM Product p WHERE (p.price-((p.price_net / 100) * p.price))>?1 and (p.price-((p.price_net / 100) * p.price)) <= ?2 and p.cateid=1 and CONCAT(LOWER(p.brand)) LIKE %?3%")
	public List<Product> Filter(Double price_small,Double price_large,String brand);
	@Query("SELECT p FROM Product p WHERE CONCAT(LOWER(p.brand)) LIKE %?1% and p.cateid=1")
	public List<Product> FilterBrand(String brand);
	@Query("SELECT p FROM Product p WHERE (p.price-((p.price_net / 100) * p.price))>?1 and (p.price-(p.price_net / 100) * p.price) <= ?2 and p.cateid=1")
	public List<Product> FilterPrice(Double price_small,Double price_large);
	

	
	
}
