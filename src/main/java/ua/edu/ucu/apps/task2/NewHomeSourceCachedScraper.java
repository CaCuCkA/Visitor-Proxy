package ua.edu.ucu.apps.task2;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class NewHomeSourceCachedScraper extends Scraper {
    private final NewHomeSourceScraper generalScraper = new NewHomeSourceScraper();

    public List<String> scrape(String location) throws SQLException {
        List<String> outputData;
        location = location.toLowerCase();

        outputData = database.getCache(location);
        if (!outputData.isEmpty()) {
            System.out.println("Found cache-data in database for location: " + location);
            return outputData;
        }

        System.out.println("No cache-data was found for location: " + location + " Scraping...");
        outputData = generalScraper.scrape(location);

        if (!outputData.isEmpty()) {
            database.setCache(location, outputData);
        }

        return outputData;
    }

}
