package vn.com.phongvucrawler.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
//	@Autowired
//	PVDataRepository data;

	@RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
	public String Home(Model model) {
//		model.addAttribute("datalist", data.findAll());
		return "index";
	}
	
	@RequestMapping(value = { "/hi" }, method = RequestMethod.GET)
	public String Home1(Model model) {
//		model.addAttribute("datalist", data.findAll());
		return "home";
	}
}
