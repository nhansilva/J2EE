package vn.com.phongvucrawler.Controller;
import static java.lang.System.out;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import vn.com.phongvucrawler.DAO.MongoDBService;
import vn.com.phongvucrawler.Entity.ProductInformation;
public class ProductInformationCrawler extends WebCrawler {
	 private static final Logger logger = LoggerFactory.getLogger(ProductInformationCrawler.class);
	 public static final MongoDBService mongoDBService = MongoDBService.getInstance();

	    private static final Pattern FILTERS = Pattern.compile(".*(\\.("
	            + "css|js"
	            + "|bmp|gif|jpe?g|JPE?G|png|tiff?|ico|nef|raw"
	            + "|mid|mp2|mp3|mp4|wav|wma|flv|mpe?g"
	            + "|avi|mov|mpeg|ram|m4v|wmv|rm|smil"
	            + "|pdf|doc|docx|pub|xls|xlsx|vsd|ppt|pptx"
	            + "|swf"
	            + "|zip|rar|gz|bz2|7z|bin"
	            + "))$");

	    private static final String DOMAIN = "https://phongvu.vn/";
	    private static final Pattern NEWS_PAGE = Pattern.compile("https://phongvu\\.vn\\/.+\\.html");
//	    private static final Pattern CATELOGIES_PAGES = Pattern.compile("https://phongvu\\.vn\\/.+/");

	    @Override
	    public boolean shouldVisit(Page referringPage, WebURL url) {
	        String href = url.getURL().toLowerCase();

	        return !FILTERS.matcher(href).matches()
	                && href.startsWith(DOMAIN)
	                && !href.contains("/landing")
	                && !href.contains("/buildpc")
	                && !href.contains("/contact")
	                && !href.contains("/contact")
	                && !href.contains("/hoi-dap")
	                && !href.contains("/media")
	                && !href.contains("/skin")
	                && !href.contains(".cat")
	                && !href.contains("/checkout");
	    }

	    @Override
	    public void visit(Page page) {

	        String url = page.getWebURL().getURL();

	        out.print("Visiting " + url);
	        if (!NEWS_PAGE.matcher(url).matches() /*|| CATELOGIES_PAGES.matcher(url).matches()*/) {
	            out.println(" -- skipped");
	            return;
	        }

	        if (page.getParseData() instanceof HtmlParseData) {
	            ProductInformation productInformation;
	            out.println("\nStart get html...");
	            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
	            String html = htmlParseData.getHtml();
	            out.println("\nGet html successful...");
	            ProductInformationParser productInformationParser = new ProductInformationParser();
	            out.println("\nParsing data...");
	            productInformation = productInformationParser.parseFromHTML(html);
	            productInformation.setProductUrl(url);
	            out.println("\nParsing data complete...");
	            ProductInformationCrawler.mongoDBService.insertProductInformation(productInformation);
	            out.println(" -- parsed");
	        } else {
	            out.println("Instance error");
	        }

	    }
}
