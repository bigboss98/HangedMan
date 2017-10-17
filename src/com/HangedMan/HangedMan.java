

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
		boolean isWin = false;

		secretWord = insertSecretWord();

		int lengthWord = secretWord.length();
		char[] word = new char[lengthWord];

		//Turno di gioco
		while(errors <= MAX_ERRORS && !isWin) {

			// Voglio solo la maglietta :D
			// 2

			System.out.println("\nTenta una lettera:");
			insertedChar = input.nextLine();//Lettura carattere

			//Controllo inserimento di soltanto un carattere
			while(insertedChar.length() > 1){
				System.out.println("ERROR!!!! Devi inserire soltanto una lettera.");
				System.out.println("Inserisci lettera!!!");
				insertedChar = input.nextLine();
			}

			//Controllo occorenze tra lettera inserita e la parola segreta
			if(secretWord.contains(insertedChar)) {
				System.out.println("Bravo la lettera " + insertedChar + " è contenuta la parola segreta");
				int index = secretWord.indexOf(insertedChar);
				word[index] = insertedChar.charAt(0);

			}else{
				System.out.println("La lettera " + insertedChar + "  non è contenuta la parola segreta");
				errors++;
			}

			//Controllo vittoria
			if(secretWord.equals(word)){
				isWin = true;
			}

			printHangedMan(errors,word,lengthWord);

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
	public static void printHangedMan(int errors,char[] word,int lengthWord) {

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


		//NON RIESCO A MOSTRARE LE PAROLE TROVATE
		for(int x = 0; x < lengthWord;++x){
			if(word[x] == ' '){
				System.out.print(" _ ");
			}else{
				System.out.print(word[x]);
			}
		}


	}

	/**
	 * Metodo che inserisce la parola segreta tramite inserimento dell'Utente
	 * Ritorna la stringa inserita
	 *
	 *fdsdhkjdhkjfddhkajfdsahkjfdkjhdahkjfddafhkjdfhkjdsakdjhfsdfkjhaafds
	 */
	public static String insertSecretWord(){
		System.out.println("Inserisci la parola segreta: ");
		String word = input.nextLine();
		return word;
	}

}
