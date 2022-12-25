package ua.edu.ucu.apps.task2;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        NewHomeSourceCachedScraper cachedScraper = new NewHomeSourceCachedScraper();

        List<String> result1 = cachedScraper.scrape("kyiv");
        System.out.println("==================");
        List<String> result2 = cachedScraper.scrape("chicago");

        result1.forEach(System.out::println);
        result2.forEach(System.out::println);
    }
}
