package vn.com.phongvucrawler.Repository;


import org.springframework.data.repository.CrudRepository;

import vn.com.phongvucrawler.Entity.ProductInformation;

public interface PVDataRepository extends CrudRepository<ProductInformation, Long>  {
	
}
