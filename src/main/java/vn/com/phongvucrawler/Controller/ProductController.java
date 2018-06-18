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
@Controller
public class ProductController {
	@Autowired
	PVDataRepository data;
	@Autowired
	PVDataRepositoryCustom dt;
	public String category;
	public String catagoryStandard;
	@RequestMapping(value = { "/home/{productCatelogy}" }, method = RequestMethod.GET)
	public String changePageLapTop(Model model, @PathVariable String productCatelogy) {
		List<ProductInformation> ls = new ArrayList<ProductInformation>();
		if(productCatelogy.equals("LapTop"))
		{
			ls = dt.findByCategory("Laptop");
			category = "LapTop";
			catagoryStandard = "LapTop";
		}
		else if(productCatelogy.equals("MHMT"))
		{
			ls = dt.findByCategory("Màn Hình Máy Tính");
			category = "MHMT";
			catagoryStandard = "Màn Hình Máy Tính";
		}
		else if(productCatelogy.equals("Mobile"))
		{
			ls = dt.findByCategory("Điện Thoại & Tablet");
			category = "Mobile";
			catagoryStandard = "Điện Thoại & Tablet";
		}
		else if(productCatelogy.equals("Key"))
		{
			ls = dt.findByCategory("Chuột, Bàn Phím, Pad");
			catagoryStandard = "Chuột, Bàn Phím, Pad";
			category = "Key";
		}
		else if(productCatelogy.equals("PhuKien"))
		{
			ls = dt.findByCategory("Phụ Kiện");
			category = "PhuKien";
			catagoryStandard = "Phụ Kiện";
		}
		else if(productCatelogy.equals("Audio"))
		{
			ls = dt.findByCategory("Thiết Bị Âm Thanh");
			category = "Audio";
			catagoryStandard = "Thiết Bị Âm Thanh";
		}
		else if(productCatelogy.equals("Security"))
		{
			ls = dt.findByCategory("Thiết Bị An Ninh");
			category = "Security";
			catagoryStandard = "Thiết Bị An Ninh";
		}
		else if(productCatelogy.equals("Computer"))
		{
			ls = dt.findByCategory("Máy tính đồng bộ");
			category = "Computer";
			catagoryStandard = "Máy tính đồng bộ";
		}
		else if(productCatelogy.equals("VP"))
		{
			ls = dt.findByCategory("Thiết Bị Văn Phòng");
			category = "VP";
			catagoryStandard = "Thiết Bị Văn Phòng";
		}
		model.addAttribute("ls", ls);
		model.addAttribute("cata", category);
		model.addAttribute("namecata",catagoryStandard);
		
		return "products";
	}
}
