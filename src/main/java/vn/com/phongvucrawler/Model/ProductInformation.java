package vn.com.phongvucrawler.Model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Indexed;

@Document(collection = "ProductInformation")
public class ProductInformation {
 
    private String productId;
    
    @Field(value = "productName")
    private String productName;
    
    @Field(value = "productPrice")
    private String productPrice;
    
    @Field(value = "productBrand")
    private String productBrand;
    
    @Field(value = "productCatelogy")
    private List<String> productCatelogy;
    
    @Field(value = "productImage")
    private List<String> productImage;
    
    @Field(value = "productDescription")
    private String productDescription;
    
    @Field(value = "productSpecification")
    private HashMap<String, String> productSpecification;
    
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
        return productCatelogy;
    }

    public void setProductCatelogies(List<String> productCatelogies) {
        this.productCatelogy = productCatelogies;
    }

    public List<String> getProductImages() {
        return productImage;
    }

    public void setProductImages(List<String> productImages) {
        this.productImage = productImages;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public HashMap<String, String> getProductSpecifications() {
        return productSpecification;
    }

    public void setProductSpecifications(HashMap<String, String> productSpecifications) {
        this.productSpecification = productSpecifications;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

   

}
