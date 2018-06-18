package vn.com.phongvucrawler.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.phongvucrawler.Model.ProductInformation;
import vn.com.phongvucrawler.Repository.PVDataRepository;
import vn.com.phongvucrawler.Repository.PVDataRepositoryCustom;

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
	
	
	
	
	
}
