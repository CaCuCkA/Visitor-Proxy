package ua.edu.ucu.apps.task2;


import org.jsoup.nodes.Document;

public abstract class Scraper {
    final String url = "https://www.newhomesource.com/locationhandler/searchtext-{location}#skip-to-content";

    boolean available(Document document) {
        return !document.select("div.clearfix")
                .select("h3").text().contains("We could not find any homes");
    }
}
