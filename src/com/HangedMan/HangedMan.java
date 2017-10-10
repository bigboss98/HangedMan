

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
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		String insertedChar;
		String secretWord;
		int errors = 0;
		
		secretWord = insertSecretWord();

		int lengthWord = secretWord.length();
		char[] word = new char[lengthWord];

		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		//Turno di gioco
		while(errors <= MAX_ERRORS) {
			
			System.out.println("Tenta una lettera:");
			insertedChar = input.next();//Lettura carattere
			
			if(secretWord.contains(insertedChar)) {
				System.out.println("Bravo la lettera " + insertedChar + " è contenuta la parola segreta");
				int index = secretWord.indexOf(insertedChar);
				word[index] = insertedChar.charAt(0);

			}else{
				errors++;
			}
			
			
			
			printHangedMan(errors,word);
			
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
	
	/**
	 * Metodo che stampa l'impiccato
	 * Parametri: numero degli errori e la stringa della parola conosciuta al momento
	 * Return void
	 */
	public static void printHangedMan(int errors,char[] word) {
		
		String[] hangedManarray = new String[LENGTH_WINDOW];
		
		 hangedManarray[0] = "|___";
		 hangedManarray[1] = (errors >= 0) ? "|" : "";
		 hangedManarray[2] = (errors >= 0) ? "|     " + ((errors >= 4) ? '/': "" ) + ((errors >= 5 ) ? " \\" : "") : "";
		 hangedManarray[3] = (errors >= 1) ? "|      " + ((errors >= 3) ?  " |" : "") : "";
		 hangedManarray[4] = (errors >= 1) ? "|     " + ((errors >= 6) ? "\\" : "") + ((errors >= 3) ? " |" : "") + ((errors >= 7) ? "/" : "") : ""; 
		 hangedManarray[5] = (errors >= 2) ? "|     " + ((errors == 8) ? "(_)" : "|") : "";
		 hangedManarray[6] = (errors >= 2) ? "|/     |" : "";
		 hangedManarray[7] = (errors >= 3) ? "____________" : "";
		
		for(int i = LENGTH_WINDOW - 1; i >= 0 ; i--) {
			System.out.println(hangedManarray[i]);
		}

		for(char x : word){
			if(x == ' '){
				System.out.print("_ ");
			}else{
				System.out.print(x);
			}
		}
		

	}

	/**
	 * Metodo che inserisce la parola segreta tramite inserimento dell'Utente
	 * Ritorna la stringa inserita
	 */
	public static String insertSecretWord(){
		System.out.println("Inserisci la parola segreta: ");
		String word = input.nextLine();
		return word;
	}

}
