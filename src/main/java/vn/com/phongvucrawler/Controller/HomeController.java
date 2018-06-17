package vn.com.phongvucrawler.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.phongvucrawler.Entity.ProductInformation;
import vn.com.phongvucrawler.Repository.PVDataRepository;
import vn.com.phongvucrawler.Repository.PVDataRepositoryCustom;

@Controller
public class HomeController {
	@Autowired
	PVDataRepository data;
	@Autowired
	PVDataRepositoryCustom data1;

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String Home(Model model) {
		List<ProductInformation> lsLapTop = new ArrayList<ProductInformation>();
		lsLapTop = data1.findByCategory("Laptop");
		List<String> lsImage = new ArrayList<String>();
		List<ProductInformation> lsMobile = new ArrayList<ProductInformation>();
		lsMobile = data1.findByCategory("Điện Thoại & Tablet");
		List<ProductInformation> lsLinhKien = new ArrayList<ProductInformation>();
		lsLinhKien = data1.findByCategory("Linh Kiện Máy Tính");
		model.addAttribute("lsLapTop", lsLapTop);
		model.addAttribute("lsMobile", lsMobile);
		model.addAttribute("lsLapTop1",lsImage);
		model.addAttribute("lsLinhKien",lsLinhKien);
		for(ProductInformation pro:lsLapTop)
		{
//			for(String imageUri:pro.getProductImages()) {
//				System.out.println();
//			}
			System.out.println(pro.getProductImages().get(0));
				
		}
		return "index";
	}

	@RequestMapping(value = { "/hi" }, method = RequestMethod.GET)
	public String Home1(Model model) {
		// model.addAttribute("datalist", data.findAll());
		return "product";
	}
}
