package edu.wpi.cs3733;

import edu.wpi.cs3733.entity.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Cipher application controller; don't modify this file (except for note below)
 */
public class CipherController {

	@FXML
	TextField textInputBox;

	@FXML
	TextArea caesarTextOut;

	@FXML
	TextArea elbonianTextOut;

	private Message cleartext;
	private CaesarCipher caesarCipher;
	private ElbonianCipher elbonianCipher;

	public CipherController(){
		cleartext = new Message();
		caesarCipher = new CaesarCipher();
		elbonianCipher = new ElbonianCipher();

		/*
		 * You may add additional code here if it relates to your observer pattern implementation.
		 */

	}

	/**
	 * Runs once every time the text in the input box changes. Your observer pattern implementation should allow
	 * for the text contained inside the different cipher objects to change despite that their setText() functions are
	 * never explicitly called here.
	 */
	@FXML
	public void onTextUpdate(){
		cleartext.setText(textInputBox.getText());
	}

	/**
	 * Runs when the user clicks the 'Encode!' button
	 */
	@FXML
	public void updateOutput(){
		caesarTextOut.setText(caesarCipher.getText());
		elbonianTextOut.setText(elbonianCipher.getText());
	}
}
