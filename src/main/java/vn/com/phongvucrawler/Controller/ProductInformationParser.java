package vn.com.phongvucrawler.Controller;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import vn.com.phongvucrawler.Entity.ProductInformation;
import vn.com.phongvucrawler.Utils.StringUtils;


public class ProductInformationParser {
	public ProductInformation parseFromHTML(String html) {
        ProductInformation productInformation = new ProductInformation();
        Document doc = Jsoup.parse(html);

        //Parse productId
        Element productId = doc.selectFirst("div.detail-product-sku b");
        if (productId != null) {
            productInformation.setProductId(productId.text());
            out.println("\nproductId: " + productInformation.getProductId());
        }

        //Parse productName
        Element productName = doc.selectFirst("h1.detail-product-name");
        if (productName != null) {
            productInformation.setProductName(productName.text());
            out.println("\nproductName: " + productInformation.getProductName());
        }

        //Parse productPrice
        Element productPrice = doc.selectFirst("div.detail-product-final-price");
        if (productPrice != null) {
            productInformation.setProductPrice(productPrice.text());
            out.println("\nproductPrice: " + productInformation.getProductPrice());
        }

        //Parse productDescription
        Element productDescription = doc.selectFirst("div.detail-product-desc div.detail-product-desc-content");
        if (productDescription != null) {
            productInformation.setProductDescription(productDescription.text());
            out.println("\nproductDesc: " + productInformation.getProductDescription());
        }

        //Parse productCatelogies   
        Elements productCatelogies = doc.select("div.breadcrumbs a");
        if (productCatelogies != null) {
            ArrayList<String> catelogies = new ArrayList<String>();
            productCatelogies.remove(0);
            for (Element productCatelogy : productCatelogies) {
                String catelogy = productCatelogy.text();
                catelogies.add(catelogy);
            }
            productInformation.setProductCatelogies(catelogies);
            for (String catelogy : productInformation.getProductCatelogies()) {
                out.println("\nList catelogy: " + catelogy);
            }
        }

        //Parse productImage
        Elements imageLinks = doc.select("div#myModal div.modal-content div.mySlides" /*img[src~=(?i)\\\\.(png|jpe?g|gif)]"*/);
        List<String> links = new ArrayList<String>();
        if (imageLinks != null) {
            for (Element imageLink : imageLinks) {
                String link = imageLink.select("img").attr("src");
                links.add(link);
            }
            productInformation.setProductImages(links);
            for (String url : productInformation.getProductImages()) {
                out.println("\nList image url: " + url);
            }
        }

        //Parse productSpecification + productBrand
        Elements productSpecifications = doc.select("div#attributePopup div.modal-dialog div.modal-content div.modal-body table.table.attribute-table tbody tr");
        if (productSpecifications != null) {
            //Parse productBrand
            boolean isLabelBaoHanh = false;
            Element lable = productSpecifications.get(0).selectFirst("th.attribute-label");
            if (StringUtils.removeAccent(lable.text()).equals("Bao hanh (thang)")) {
                isLabelBaoHanh = true;
            }

            if (isLabelBaoHanh) {
                Element productBrand = productSpecifications.get(1).selectFirst("td.attribute-value");
                productInformation.setProductBrand(productBrand.text());
            } else {
                Element productBrand = productSpecifications.get(0).selectFirst("td.attribute-value");
                productInformation.setProductBrand(productBrand.text());
            }
//            for (String cat : productInformation.getProductCatelogies()) {
//                if (StringUtils.removeAccent(cat).equals("Man Hinh May Tinh")) {
//                    isComputerScreen = true;
//                } else if (StringUtils.removeAccent(cat).equals("Card Man Hinh - VGA")) {
//                    isVGA = true;
//                }
//            }
//            if (isComputerScreen || isVGA) {
//                Element productBrand = productSpecifications.get(0).selectFirst("td.attribute-value");
//                productInformation.setProductBrand(productBrand.text());
//            } else {
//                Element productBrand = productSpecifications.get(1).selectFirst("td.attribute-value");
//                productInformation.setProductBrand(productBrand.text());
//            }
            out.println("\nproductBrand: " + productInformation.getProductBrand());

            //Specifications  
            HashMap<String, String> specifications = new HashMap<String, String>();
            for (Element row : productSpecifications.select("tr")) {
                String label = row.selectFirst("th.attribute-label").text();
                String value = row.selectFirst("td.attribute-value").text();
                specifications.put(label, value);
            }
            productInformation.setProductSpecifications(specifications);

            Set set = productInformation.getProductSpecifications().entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                System.out.print(mentry.getKey() + "\t");
                System.out.println(mentry.getValue());
            }
        }

        return productInformation;
    }
}
