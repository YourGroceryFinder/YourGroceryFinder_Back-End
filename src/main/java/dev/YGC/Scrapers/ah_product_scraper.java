package dev.YGC.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ah_product_scraper {
    void AHProducts() throws IOException, InterruptedException {
        String[] CategoryLinks = {
                "https://www.ah.nl/producten/aardappel-groente-fruit?page=32/",
                "https://www.ah.nl/producten/salades-pizza-maaltijden?page=19/",
                "https://www.ah.nl/producten/vlees-kip-vis-vega?page=27/",
                "https://www.ah.nl/producten/kaas-vleeswaren-tapas?page=41/",
                "https://www.ah.nl/producten/zuivel-plantaardig-en-eieren?page=31/",
                "https://www.ah.nl/producten/bakkerij-en-banket?page=27/",
                "https://www.ah.nl/producten/ontbijtgranen-en-beleg?page=51/",
                "https://www.ah.nl/producten/snoep-koek-chips-en-chocolade?page=76/",
                "https://www.ah.nl/producten/tussendoortjes?page=22/",
                "https://www.ah.nl/producten/frisdrank-sappen-koffie-thee?page=53/",
                "https://www.ah.nl/producten/wijn-en-bubbels?page=33/",
                "https://www.ah.nl/producten/bier-en-aperitieven?page=20/",
                "https://www.ah.nl/producten/pasta-rijst-en-wereldkeuken?page=56/",
                "https://www.ah.nl/producten/soepen-sauzen-kruiden-olie?page=65/",
                "https://www.ah.nl/producten/sport-en-dieetvoeding?page=6/",
                "https://www.ah.nl/producten/diepvries?page=24/",
                "https://www.ah.nl/producten/drogisterij?page=83/",
                "https://www.ah.nl/producten/baby-en-kind?page=23/",
                "https://www.ah.nl/producten/huishouden?page=27/",
                "https://www.ah.nl/producten/huisdier?page=14/",
                "https://www.ah.nl/producten/koken-tafelen-vrije-tijd?page=31/"
        };

        for (String Link : CategoryLinks){
            Document doc = Jsoup.connect(Link).get();

            Elements products = doc.select(".product-card-portrait_root__ZiRpZ");

            // Print the text content of the links
            for (Element product : products) {
                String name = product.select(".title_root__xSlPL").text();
                String price = product.select(".price-amount_root__Sa88q").text();

                System.out.println(name);
                System.out.println(price);
                System.out.println(Link);
                //_db.InsertNewProducts(name, price, "AH");
            }
        }
    }
}
