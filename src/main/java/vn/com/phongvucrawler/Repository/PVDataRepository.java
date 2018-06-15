package vn.com.phongvucrawler.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import vn.com.phongvucrawler.Entity.ProductInformation;

public interface PVDataRepository extends MongoRepository<ProductInformation, String>  {
	
}
