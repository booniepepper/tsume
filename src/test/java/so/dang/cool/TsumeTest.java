package so.dang.cool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TsumeTest {
    @Test void verifyHello() {
        var pikachu = Tsume.init()
                .s("pika")
                .s("chu!")
                .f(String::concat)
                .top();
        assertEquals("pikachu!", pikachu);
    }
}
