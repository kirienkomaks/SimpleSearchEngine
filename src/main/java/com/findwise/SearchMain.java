package com.findwise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchMain {

    public static void main(String[] args) {
        Map<String, String> documents = new LinkedHashMap<>();

        for (int i = 1; i < args.length; i++) {
            documents.put("Document " + i, args[i - 1]);
        }

        SearchEngine searchEngine = new SearchEngineImpl();

        documents.forEach(searchEngine::indexDocument);

        List<IndexEntry> entries = searchEngine.search(args[args.length - 1]);

        for (IndexEntry entry : entries) {
            System.out.println(entry.getId());
            System.out.println(entry.getScore());
        }
    }
}
