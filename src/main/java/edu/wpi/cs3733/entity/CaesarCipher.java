package edu.wpi.cs3733.entity;

import java.util.Arrays;

/**
 * Caesar cipher; you must implement the cipher and the observer pattern
 */
public class CaesarCipher implements Observer {
	private String text;
	private char[] lowerLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private char[] upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public void setText(String text){
		if(text.length() > 140){
			this.text = "";
			return;
		}

		String cipherText = "";
		for(char c : text.toCharArray()){
			if(new String(lowerLetters).contains(String.valueOf(c))){
				cipherText += lowerLetters[26 - charArrayIndexOf(c, lowerLetters) - 1];
			}else if(new String(upperLetters).contains(String.valueOf(c))){
				cipherText += upperLetters[26 - charArrayIndexOf(c, upperLetters) - 1];
			}else if(".,?! ".contains(String.valueOf(c))){
				cipherText += c;
			}else{
				this.text = "";
				return;
			}
		}

		this.text = cipherText;
	}

	public String getText(){
		return text;
	}

	private static int charArrayIndexOf(char c, char[] arr){
		for(int i = 0; i < arr.length; i++){
			if(c == arr[i]){
				return i;
			}
		}
		return -1;
	}

	@Override
	public void notify(Object object){
		this.setText((String)object);
	}
}
