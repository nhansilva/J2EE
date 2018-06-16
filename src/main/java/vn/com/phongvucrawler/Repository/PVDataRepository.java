package vn.com.phongvucrawler.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import vn.com.phongvucrawler.Model.ProductInformation;

public interface PVDataRepository extends MongoRepository<ProductInformation, String>  {
	
}
