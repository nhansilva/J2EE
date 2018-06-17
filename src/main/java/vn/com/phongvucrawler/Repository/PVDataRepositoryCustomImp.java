package vn.com.phongvucrawler.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vn.com.phongvucrawler.Model.ProductInformation;

@Repository
public class PVDataRepositoryCustomImp implements PVDataRepositoryCustom {
	@Autowired
	MongoTemplate mongoTemplate;
	
		@Override
		public List<ProductInformation> findByCategory(String nameCategory) {
			List<ProductInformation> ls;
			Query query = new Query(Criteria.where("productCatelogy").is(nameCategory));
			ls = this.mongoTemplate.find(query, ProductInformation.class);
			return ls;
		}
}
