package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    static String url = "https://www.amazon.pl";

    public static void main(String[] args) {

        Document doc;
        String toElectronic = null;
        try {

            // need http protocol
            doc = Jsoup.connect(url).get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            // get all links
            Elements carduiCards = doc.select(".a-cardui");
            for(var card: carduiCards) {
                Element cardHeader = card.selectFirst(".a-cardui-header > h2");
                System.out.println(cardHeader.text());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(url + "/" + toElectronic);



    }

}