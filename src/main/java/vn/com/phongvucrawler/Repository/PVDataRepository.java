package vn.com.phongvucrawler.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import vn.com.phongvucrawler.Entity.ProductInformation;

public interface PVDataRepository extends MongoRepository<ProductInformation, String>  {
	ProductInformation findProductInfoation(String productId);
}
