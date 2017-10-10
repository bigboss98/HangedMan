package com.HangedMan;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programma che simula il gioco dell'Impiccato
 * Authors Bigboss98 Gianlo98
 * Version 0.1
 */
public class HangedMan {

	public static final int MAX_ERRORS = 8;
	public static final int LENGTH_WINDOW = 8;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		CharSequence insertedChar;
		
		System.out.println("Inserisci la parola segreta: ");
		String secretWord = scanner.nextLine();
		
		System.out.print("\033[H\033[2J");
		System.out.flush();


		int errors = 0;
		
		while(errors <= 8) {
			
			System.out.println("Tenta una lettera:");
			//insertedChar = scanner.next().charAt(0);
			
			/*if(secretWord.contains(insertedChar)) {
				
			}*/
			
			
			
			printHangedMan(errors++);
			
		}
		
		System.out.println("Fine, hai perso!!!");
		System.exit(0);
		
		
		
		
		
	}
	
	/*
	 * 
	3 ___________
      |/      |    
      |      (_)    8 (fine)
    2 |      \|/    6 7
      |       |    
    1 |      / \   4 5
      |
    0 |___
	 * 
	 * 
	 * 
	 */
	
	
	
	public static void printHangedMan(int errors) {
		
		String[] hangedManarray = new String[LENGHT_WINDOW];
		
		 hangedManarray[0] = "|___";
		 hangedManarray[1] = (errors >= 0) ? "|" : "";
		 hangedManarray[2] = (errors >= 0) ? "|     " + ((errors >= 4) ? '/': "" ) + ((errors >= 5 ) ? " \\" : "") : "";
		 hangedManarray[3] = (errors >= 1) ? "|      " + ((errors >= 3) ?  " |" : "") : "";
		 hangedManarray[4] = (errors >= 1) ? "|     " + ((errors >= 6) ? "\\" : "") + ((errors >= 3) ? " |" : "") + ((errors >= 7) ? "/" : "") : ""; 
		 hangedManarray[5] = (errors >= 2) ? "|     " + ((errors == 8) ? "(_)" : "|") : "";
		 hangedManarray[6] = (errors >= 2) ? "|/     |" : "";
		 hangedManarray[7] = (errors >= 3) ? "____________" : "";
		
		for(int i = LENGHT_WINDOW - 1; i >= 0 ; i--) {
			System.out.println(hangedManarray[i]);
		}
		

	}

}
