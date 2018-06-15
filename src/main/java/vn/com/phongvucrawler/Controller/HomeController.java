package vn.com.phongvucrawler.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.phongvucrawler.Repository.PVDataRepository;

@Controller
public class HomeController {
	@Autowired
	PVDataRepository data;

	@RequestMapping(value = { "/List" }, method = RequestMethod.GET)
	public String Home(Model model) {
		model.addAttribute("datalist", data.findAll());
		return "index";
	}
	
	@RequestMapping(value = { "/hi" }, method = RequestMethod.GET)
	public String Home1(Model model) {
//		model.addAttribute("datalist", data.findAll());
		return "home";
	}
}
