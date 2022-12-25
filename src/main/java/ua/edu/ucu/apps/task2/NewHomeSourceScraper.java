package ua.edu.ucu.apps.task2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class NewHomeSourceScraper extends Scraper {
    public List<String> scrape(String location) {
        Document document;
        List<String> outputData = List.of();
        location = location.toLowerCase();

        try {
            document = Jsoup.connect(url.replace("{location}", location)).get();
        } catch (IOException exception) {
            System.out.println("Error: url " +
                    "cannot be scraped - " + url.replace("{location}", location));
            return outputData;
        }

        boolean isAvailable = available(document);

        if (!isAvailable) {
            System.out.println("No results were found (location: " + location + ")");
            return outputData;
        }
        outputData = document.select("a.info__link").eachAttr("href");

        return outputData;
    }
}
