package vn.com.phongvucrawler.Repository;

import java.util.List;

import vn.com.phongvucrawler.Entity.ProductInformation;

public interface PVDataRepositoryCustom {
	public List<ProductInformation> findByCategory(String nameCategory);
	
}
