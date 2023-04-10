package dev.danvega.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("~/api/scraper")
public class jumbo_products_scraper {
    @GetMapping("/JumboProducts")
    void JumboProducts() throws IOException{
        for(int i = 0; i <= 18744; i += 24){
            // Parse an HTML document from a URL
            Document doc = Jsoup.connect("https://www.jumbo.com/producten/?offSet=" + i).get();

            // Extract links from the document
            Elements products = doc.select(".product-container");

            // Print the text content of the links
            for (Element product : products) {
                String name = product.select(".title-link").text();
                String image = product.select(".image").attr("src");
                String price = product.select(".whole").text() +"."+ product.select(".fractional").text();

                System.out.println(name);
                System.out.println(image);
                System.out.println(price);
                //_db.InsertNewProducts(name, image, price, "Jumbo");
            }
        }
    }
}
