import com.findwise.IndexEntry;
import com.findwise.IndexEntryImpl;
import com.findwise.SearchEngine;
import com.findwise.SearchEngineImpl;
import com.findwise.Term;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchEngineTest {

    @Test
    public void searchEngineBrownTest() {
        Map<String, String> documents = new LinkedHashMap<>() {{
            put("Document 1", "the brown fox jumped over the brown dog");
            put("Document 2", "the lazy brown dog sat in the corner");
            put("Document 3", "the red fox bit the lazy dog");
        }};

        SearchEngine searchEngine = new SearchEngineImpl();
        documents.forEach(searchEngine::indexDocument);

        List<IndexEntry> entriesBrown = searchEngine.search("brown");

        assertThat(entriesBrown.get(0).getId()).isEqualTo("Document 1");
        assertThat(entriesBrown.get(0).getScore()).isEqualTo(0.25);
        assertThat(entriesBrown.get(1).getId()).isEqualTo("Document 2");
        assertThat(entriesBrown.get(1).getScore()).isEqualTo(0.125);
    }

    @Test
    public void searchEngineFoxTest() {
        Map<String, String> documents = new LinkedHashMap<>() {{
            put("Document 1", "the brown fox jumped over the brown dog");
            put("Document 2", "the lazy brown dog sat in the corner");
            put("Document 3", "the red fox bit the lazy dog");
        }};

        SearchEngine searchEngine = new SearchEngineImpl();
        documents.forEach(searchEngine::indexDocument);

        List<IndexEntry> entriesFox = searchEngine.search("fox");

        assertThat(entriesFox.get(0).getId()).isEqualTo("Document 3");
        assertThat(entriesFox.get(0).getScore()).isEqualTo(0.14285714285714285);
        assertThat(entriesFox.get(1).getId()).isEqualTo("Document 1");
        assertThat(entriesFox.get(1).getScore()).isEqualTo(0.125);
    }

    @Test
    public void createTermTest() {

        Term term = new Term("brown", 1.0);

        assertThat(term.getTerm()).isEqualTo("brown");
        assertThat(term.getTf()).isEqualTo(1.0);
    }

    @Test
    public void createIndexEntryTest() {

        IndexEntry entry = new IndexEntryImpl();

        entry.setId("Document test 1");
        entry.setScore(0.225);

        assertThat(entry.getId()).isEqualTo("Document test 1");
        assertThat(entry.getScore()).isEqualTo(0.225);
    }
}
