package vn.com.phongvucrawler.Controller;

import java.util.ArrayList;
import java.util.List;

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
public class HomeController {
	@Autowired
	PVDataRepository data;
	@Autowired
	PVDataRepositoryCustom dt;
	public String category;

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String Home(Model model) {
		List<ProductInformation> ls = new ArrayList<ProductInformation>();
		ls = (ArrayList<ProductInformation>) data.findAll();
		List<ProductInformation> lsLapTop = new ArrayList<ProductInformation>();
		lsLapTop = dt.findByCategory("Laptop");
		List<ProductInformation> lsMobile = new ArrayList<ProductInformation>();
		lsMobile = dt.findByCategory("Điện Thoại & Tablet");
		List<ProductInformation> lsAudio = new ArrayList<ProductInformation>();
		lsAudio = dt.findByCategory("Thiết Bị Âm Thanh");
		List<ProductInformation> lsVP = new ArrayList<ProductInformation>();
		lsVP = dt.findByCategory("Thiết Bị Văn Phòng");
		List<ProductInformation> lsKey = new ArrayList<ProductInformation>();
		lsKey = dt.findByCategory("Chuột, Bàn Phím, Pad");
		model.addAttribute("lsLapTop", lsLapTop);
		model.addAttribute("lsKey", lsKey);
		model.addAttribute("lsVP", lsVP);
		model.addAttribute("lsMobile", lsMobile);
		model.addAttribute("lsAudio", lsAudio);
		lsMobile.get(0).getProductImages().get(0);
		System.out.println(lsMobile.get(0).getProductImages().get(0));
		System.out.println();
		return "home";
	}

	@RequestMapping(value = { "/home/{productCatelogy}" }, method = RequestMethod.GET)
	public String changePageLapTop(Model model, @PathVariable String productCatelogy) {
		List<ProductInformation> ls = new ArrayList<ProductInformation>();
		if(productCatelogy.equals("LapTop"))
		{
			ls = dt.findByCategory("Laptop");
			category = "LapTop";
		}
		else if(productCatelogy.equals("MHMT"))
		{
			ls = dt.findByCategory("Màn Hình Máy Tính");
			category = "MHMT";
		}
		else if(productCatelogy.equals("Mobile"))
		{
			ls = dt.findByCategory("Điện Thoại & Tablet");
			category = "Mobile";
		}
		else if(productCatelogy.equals("Key"))
		{
			ls = dt.findByCategory("Chuột, Bàn Phím, Pad");
			category = "Key";
		}
		else if(productCatelogy.equals("PhuKien"))
		{
			ls = dt.findByCategory("Phụ Kiện");
			category = "PhuKien";
		}
		else if(productCatelogy.equals("Audio"))
		{
			ls = dt.findByCategory("Thiết Bị Âm Thanh");
			category = "Audio";
		}
		else if(productCatelogy.equals("Security"))
		{
			ls = dt.findByCategory("Thiết Bị An Ninh");
			category = "Security";
		}
		else if(productCatelogy.equals("Computer"))
		{
			ls = dt.findByCategory("Máy Tính Đồng Bộ");
			category = "Computer";
		}
		else if(productCatelogy.equals("VP"))
		{
			ls = dt.findByCategory("Thiết Bị Văn Phòng");
			category = "VP";
		}
		model.addAttribute("ls", ls);
		model.addAttribute("cata", category);
		
		return "products";
	}
	
	@RequestMapping(value = { "/home/{productCatelogy}/{productId}" }, method = RequestMethod.GET)
	public String ProductDetail(Model model, @PathVariable String productCatelogy,@PathVariable String productId) {
		ProductInformation pro = new ProductInformation();
		pro = (ProductInformation) dt.findById(productId).get(0);
		String[] proDesc = StringUtils.splitLargeStringIntoListString(pro.getProductDescription());
		model.addAttribute("pro", pro);
		model.addAttribute("proDesc", proDesc);
		System.out.println(proDesc[1]);
		return "single";
	}
}
