package com.wacoco.searchFunctionality;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataSearching {
    public static final String URL = "https://www.lens.org/lens/search/patent/list";

    public static void main(String[] args) throws IOException {

        //Taking search term input from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the search term.");
        String searchTerm = scanner.nextLine();

        String URL = "https://www.lens.org/lens/search/patent/list" + "?q="+searchTerm;

        Document document= Jsoup.connect(URL).get();
        String html= document.html();
        Files.write(Paths.get("C://Users//samyu//OneDrive//Documents//file.txt"),html.getBytes());
        scanner.close();
    }
}
