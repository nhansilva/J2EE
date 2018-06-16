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

@Controller
public class HomeController {
	@Autowired
	PVDataRepository data;

	@RequestMapping(value = { "/List" }, method = RequestMethod.GET)
	public String Home(Model model) {
		List<ProductInformation> ls = new ArrayList<ProductInformation>();
		ls = (ArrayList<ProductInformation>) data.findAll();
		
		System.out.println("Hello");
		if (ls.isEmpty()) {
			System.out.println("null");
		} else {
			for (ProductInformation pro : ls) {
				System.out.println("Danh sach mat hang" + pro.getProductBrand());
			}
		}
		return "index";
	}

	@RequestMapping(value = { "/hi" }, method = RequestMethod.GET)
	public String Home1(Model model) {
		// model.addAttribute("datalist", data.findAll());
		return "home";
	}
}
