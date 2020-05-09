import edu.wpi.cs3733.entity.CaesarCipher;
import edu.wpi.cs3733.entity.ElbonianCipher;
import edu.wpi.cs3733.entity.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for your observer pattern; make sure your code works!
 * Test-driven development is a good idea here.
 */
public class ObserverTests {

    private Message observerMessage;
    private CaesarCipher caesarCipher;
    private ElbonianCipher elbonianCipher;
    private String text = "hello";

    @Test
    public void caesarObserverTest(){

        observerMessage = new Message();
        caesarCipher = new CaesarCipher();
        observerMessage.register(caesarCipher);
        observerMessage.setText(text);
        assertEquals("svool", caesarCipher.getText());
    }

    @Test
    public void elbonianObserverTest(){

        observerMessage = new Message();
        elbonianCipher = new ElbonianCipher();
        observerMessage.register(elbonianCipher);
        observerMessage.setText(text);
        assertEquals("0805121215", elbonianCipher.getText());
    }

    @Test
    public void bothObserverTest(){

        observerMessage = new Message();
        caesarCipher = new CaesarCipher();
        elbonianCipher = new ElbonianCipher();
        observerMessage.register(caesarCipher);
        observerMessage.register(elbonianCipher);
        observerMessage.setText(text);
        assertEquals("svool", caesarCipher.getText());
        assertEquals("0805121215", elbonianCipher.getText());
    }

}
