import edu.wpi.cs3733.entity.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for your cipher functions; make sure your code works!
 * Test-driven development is a good idea here.
 */
public class CipherTests {
	@Test
	public void caesarCipherTest(){
		CaesarCipher caesar = new CaesarCipher();

		caesar.setText("This is a boring message!?.,");
		assertEquals("Gsrh rh z ylirmt nvhhztv!?.,", caesar.getText());

		caesar.setText("Ex@mple");
		assertEquals("", caesar.getText());

		caesar.setText("abcdefghijklmnopqrstuvwxyz .!,? ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		assertEquals("zyxwvutsrqponmlkjihgfedcba .!,? ZYXWVUTSRQPONMLKJIHGFEDCBA", caesar.getText());
	}



}
