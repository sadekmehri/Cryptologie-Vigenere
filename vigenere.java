/*
 * Copyright (C) Sdigos to present all rights reserved.
 */

package work;

import java.util.Scanner;

public class main1 {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static String saisieCh() {
		String ch;
		do {
			System.out.println("Donner une chaine pour crypter : ");
			ch = sc.nextLine().trim();		
		}while(!testChaine(ch));
		
		return ch;
	}
	
	private static boolean testChaine(String ch) {
		boolean test = true;
		ch = ch.toLowerCase();
		for(int i=0;i<ch.length();i++) {		
			if( ((int) ch.charAt(i)) < 97 || ((int) ch.charAt(i)) > 122    ) {
				test = false;			
				break;			
			}		
		}	
		return test;
	}

	private static String saisieCle() {
		String ch;
		do {
			System.out.println("Donner la cle : ");
			ch = sc.nextLine().trim();		
		}while(!testChaine(ch));
		
		return ch;
	}
	
	private static String Cryptage(String ch,String cle) {
		int lg = cle.length();
		int j = 0,sum = 0;
		String crypt = "";
		for(int i=0;i<ch.length();i++) {			
			sum = (int) (char)ch.charAt(i)+(int)(char)cle.charAt(j)-64;
			sum = sum%26+65;
			crypt += (char)sum;
			j= (j+1)%lg;
		}		
		return crypt.toLowerCase();
	} 
	
	private static String Decryptage(String ch,String cle) {
		int lg = cle.length();
		int j = 0,sum = 0;
		String crypt = "";
		for(int i=0;i<ch.length();i++) {	
			sum = (int) (char)ch.charAt(i)-(int)(char)cle.charAt(j);
			sum = sum%26+65;
			crypt += (char)sum;
		    j= (j+1)%lg;
		}		
		return crypt.toLowerCase();
	} 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ch =  saisieCh();
		ch = ch.toLowerCase();
		String cle = saisieCle();
		cle = cle.toLowerCase();
		
		
		String crypt = Cryptage(ch,cle);
		String decrypt = Decryptage(crypt,cle);
		System.out.println("\n\t ******** Cryptage en cours ******** \t\n");
		System.out.println("Chaine initiale : "+ch+"\nChaine cryptée  : "+crypt+" \n");
		System.out.println("\t ******** Decryptage en cours ******** \t\n");
		System.out.println("Chaine cryptée    : "+crypt+"\nChaine decryptée  : "+decrypt+" \n");
		
		

	}

}
