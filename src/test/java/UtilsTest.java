import com.findwise.utils.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void parseContentTest() {

        String content = "the brown fox jumped over the brown dog";

        List<String> parsedContent = Util.parseContent(content);

        assertThat(parsedContent.size()).isEqualTo(8);
        assertThat(parsedContent.get(0)).isEqualTo("the");
    }

    @Test
    public void computeTfTest() {

        Integer wordsCount = 3;
        Integer contentSize = 10;

        double tf = Util.tf(wordsCount, contentSize);

        assertThat(tf).isEqualTo(0.3);
    }

    @Test
    public void computeIdfTest() {

        Integer documentsCount = 3;
        Integer entriesCount = 2;

        double idf = Util.idf(documentsCount, entriesCount);

        assertThat(idf).isEqualTo(1.0);
    }

    @Test
    public void computeTfIdfTest() {

        double tf = 0.5;
        double idf = 1.1;

        double tfIdf = Util.tfIdf(tf, idf);

        assertThat(tfIdf).isEqualTo(0.55);
    }
}
