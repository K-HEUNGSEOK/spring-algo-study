package hello.typeconverter.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyNumberFormatterTest {
    MyNumberFormatter myNumberFormatter = new MyNumberFormatter();
    @Test
    void parse() throws ParseException {
        Number parse = myNumberFormatter.parse("1,000", Locale.KOREA);
        Assertions.assertThat(parse).isEqualTo(1000L); //Long 타입 주의
    }

    @Test
    void print() {
        String print = myNumberFormatter.print(1000, Locale.KOREA);
        Assertions.assertThat(print).isEqualTo("1,000");

    }
}