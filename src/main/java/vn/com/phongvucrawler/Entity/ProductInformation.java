package vn.com.phongvucrawler.Entity;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ProductInformation")
public class ProductInformation {
	@Id
	private String productId;
	@Field(value = "productName")
	private String productName;
	@Field(value = "productPrice")
	private String productPrice;
	@Field(value = "productBrand")
	private String productBrand;
	@Field(value = "Emp_No")
	private List<String> productCatelogies;
	private List<String> productImages;
	private String productDescription;
	private HashMap<String, String> productSpecifications;
	@Field(value = "productUrl")
	private String productUrl;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public List<String> getProductCatelogies() {
		return productCatelogies;
	}
	public void setProductCatelogies(List<String> productCatelogies) {
		this.productCatelogies = productCatelogies;
	}
	public List<String> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<String> productImages) {
		this.productImages = productImages;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public HashMap<String, String> getProductSpecifications() {
		return productSpecifications;
	}
	public void setProductSpecifications(HashMap<String, String> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	
}
