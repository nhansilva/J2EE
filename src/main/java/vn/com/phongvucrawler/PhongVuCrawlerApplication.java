package vn.com.phongvucrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vn.com.phongvucrawler.DAO.MongoDBService;

@SpringBootApplication
public class PhongVuCrawlerApplication {
	public static final MongoDBService mongoDBService = MongoDBService.getInstance();

	public static void main(String[] args) {
		SpringApplication.run(PhongVuCrawlerApplication.class, args);
	}

}
