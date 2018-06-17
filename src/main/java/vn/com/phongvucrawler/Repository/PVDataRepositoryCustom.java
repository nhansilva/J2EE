package vn.com.phongvucrawler.Repository;

import java.util.List;

import vn.com.phongvucrawler.Model.ProductInformation;

public interface PVDataRepositoryCustom {
	public List<ProductInformation> findByCategory(String nameCategory);
	public List<ProductInformation> findById(String Id);
}
