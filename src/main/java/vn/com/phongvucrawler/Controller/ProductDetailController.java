package vn.com.phongvucrawler.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.phongvucrawler.Model.ProductInformation;
import vn.com.phongvucrawler.Repository.PVDataRepository;
import vn.com.phongvucrawler.Repository.PVDataRepositoryCustom;
import vn.com.phongvucrawler.Utils.StringUtils;

@Controller
public class ProductDetailController {
	
	@Autowired
	PVDataRepository data;
	@Autowired
	PVDataRepositoryCustom dt;
	public String category;
	@RequestMapping(value = { "/home/{productCatelogy}/{productId}" }, method = RequestMethod.GET)
	public String ProductDetail(Model model, @PathVariable String productCatelogy,@PathVariable String productId) {
		String relatedCata;
		relatedCata = productCatelogy;
		ProductInformation pro = new ProductInformation();
		pro = (ProductInformation) dt.findById(productId).get(0);
		String[] proDesc = StringUtils.splitLargeStringIntoListString(pro.getProductDescription());
		
		List<ProductInformation> relatedProductTemp = dt.findByCategory(pro.getProductCatelogies().get(0));
		List<ProductInformation> relatedProduct = new ArrayList<ProductInformation>();
		int length = relatedProductTemp.size();
		int index;
		Random randomGenerate = new Random();
		for(int i =0; i < 4; i++)
		{
			index = randomGenerate.nextInt(length-1);
			relatedProduct.add(relatedProductTemp.get(index));
		}
		System.out.println(relatedProduct.size());
		model.addAttribute("relatedProduct", relatedProduct);
		model.addAttribute("pro", pro);
		model.addAttribute("proDesc", proDesc);
		model.addAttribute("cataRelated", relatedCata);
		return "single";
	}
}
