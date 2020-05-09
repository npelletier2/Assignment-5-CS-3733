import edu.wpi.cs3733.entity.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for your cipher functions; make sure your code works!
 * Test-driven development is a good idea here.
 */
public class CipherTests {
	@Test
	public void caesarCipherTest(){
		CaesarCipher cipher = new CaesarCipher();

		cipher.setText("This is a boring message!?.,");
		assertEquals("Gsrh rh z ylirmt nvhhztv!?.,", cipher.getText());

		cipher.setText("Ex@mple");
		assertEquals("", cipher.getText());

		cipher.setText("abcdefghijklmnopqrstuvwxyz .!,? ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		assertEquals("zyxwvutsrqponmlkjihgfedcba .!,? ZYXWVUTSRQPONMLKJIHGFEDCBA", cipher.getText());

		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.?! ".toCharArray();

		Random rand = new Random();
		String text = "";
		for(int i = 0; i < 141; i++){
			text += chars[Math.abs(rand.nextInt() % chars.length)];
		}

		cipher.setText(text);
		assertEquals("", cipher.getText());
	}

	@Test
	public void elbonianCipherTest(){
		ElbonianCipher cipher = new ElbonianCipher();

		cipher.setText("This is 1 message!");
		assertEquals("20080919S0919SaS13051919010705!", cipher.getText());

		cipher.setText("Ex@mple");
		assertEquals("", cipher.getText());

		cipher.setText("abcdefghijklmnopqrstuvwxyz .!,? ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		assertEquals("0102030405060708091011121314151617181920212223242526S.!,?S0102030405060708091011121314151617181920212223242526", cipher.getText());

		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.?! 0123456789".toCharArray();

		Random rand = new Random();
		String text = "";
		for(int i = 0; i < 150; i++){
			text += chars[Math.abs(rand.nextInt() % chars.length)];
		}

		ElbonianCipher cipher2 = new ElbonianCipher();

		cipher.setText(text);
		cipher2.setText(text.substring(0, 140));
		assertEquals(cipher2.getText(), cipher.getText());
	}

}
