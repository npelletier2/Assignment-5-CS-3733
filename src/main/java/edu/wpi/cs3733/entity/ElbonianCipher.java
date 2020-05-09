package edu.wpi.cs3733.entity;

/**
 * Elbonian cipher; you must implement the cipher and the observer pattern
 */
public class ElbonianCipher implements Observer {
	private String text;
	private char[] lowerLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private char[] upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public void setText(String text){
		int max = 140;
		if(text.length() < 140) max = text.length();
		text = text.substring(0, max);

		String cipherText = "";
		for(char c : text.toCharArray()){
			if(new String(lowerLetters).contains(String.valueOf(c))){
				cipherText += String.format("%02d", charArrayIndexOf(c, lowerLetters) + 1);
			}else if(new String(upperLetters).contains(String.valueOf(c))){
				cipherText += String.format("%02d", charArrayIndexOf(c, upperLetters) + 1);
			}else if("123456789".contains(String.valueOf(c))){
				cipherText += lowerLetters[Character.getNumericValue(c) - 1];
			}else if(c == '0'){
				cipherText += '_';
			}else if(c == ' '){
				cipherText += 'S';
			}else if (",.!? ".contains(String.valueOf(c))){
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

	}
}
