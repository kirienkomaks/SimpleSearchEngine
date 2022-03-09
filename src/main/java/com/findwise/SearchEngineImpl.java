package com.findwise;

import com.findwise.utils.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchEngineImpl implements SearchEngine {

    private Map<String, List<Term>> docIndexedTerms = new HashMap<>();

    @Override
    public void indexDocument(String id, String content) {
        List<Term> docTerms = new ArrayList<>();

        Map<String, Integer> wordsCount = new HashMap<>();

        List<String> parsedContent = Util.parseContent(content);

        int contentSize = parsedContent.size();

        parsedContent.forEach(word -> {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        });

        wordsCount.forEach((word, count) -> docTerms.add(new Term(word, Util.tf(count, contentSize))));

        docIndexedTerms.put(id, docTerms);
    }

    @Override
    public List<IndexEntry> search(String term) {

        List<IndexEntry> indexEntries = new ArrayList<>();

        int documentsCount = docIndexedTerms.size();

        docIndexedTerms = docIndexedTerms.entrySet().stream()
                .filter(x -> x.getValue().stream().anyMatch(id -> id.getTerm().equals(term)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        double idf = Util.idf(documentsCount, docIndexedTerms.size());

        docIndexedTerms.forEach((key, terms) -> {

            IndexEntry indexEntry = new IndexEntryImpl();
            indexEntry.setId(key);
            double tf = terms.stream().filter(t -> t.getTerm().equals(term)).map(Term::getTf).findFirst().orElse(0.0);

            indexEntry.setScore(Util.tfIdf(tf, idf));

            indexEntries.add(indexEntry);
        });

        return indexEntries.stream().sorted(Comparator.comparing(IndexEntry::getScore).reversed()).collect(Collectors.toList());
    }
}
