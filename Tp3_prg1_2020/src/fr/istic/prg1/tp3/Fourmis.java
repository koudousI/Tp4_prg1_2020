package fr.istic.prg1.tp3;

public class Fourmis {
	   
	/**
	 * @param s
	 * 		  un terme de la suite des fourmis
	 * @pre   s.length()
	 * @return le terme suivant de la suite des fourmis
	 */
	
	
	
	/**
	 *  terme veux dire caractere 
	 *  uisuivant est le terme suivant
	 * @param ui
	 * @return calcul du terme suivant. un seul terme set calculer à partir de ui
	 */
	public static String next(String ui) {
		char terme = ' ';
		String uiSuivant = "";
		int  cpt = 1;
		
		/*
		 * On parcours la chaine Ui passée en paramètre
		 */
		for(int i = 0; i<ui.length(); i++) {
			/*
			 * **** traitement lorsque terme identique à sauvegarde ******
			 * 
			 * Si terme identique à celui sauvegarder précédement =>
			 * incrémentation le cpt
			 */
			//terme = ui.charAt(i);
			if( terme == (ui.charAt(i))  ) {
				cpt ++;
				
				/*
				 * Dans ce bloc terme identique de sauvegarde
				 * 
				 * maintenant Si on est au dernier terme de la chaine =>
				 * alors on incrémente uiSuivant
				 * ex:
				 *  Cas ui=u0=1 On est au dernier terme de la chaine, alors
				 *  incrementation de uiSuivant
				 */
				if (i==ui.length()-1) {
					uiSuivant = uiSuivant + String.valueOf(cpt) + ui.charAt(i);
				}
			}
			
			/*
			 * **** traitement lorsque terme differend de sauvegarde ******
			 * 
			 * Sinon terme different de celui sauvegarder précédement  
			 */
			else {
				
				
				/*
				 * Si on n'est au dernier terme de la chaine =>
				 * incrementation de uiSuivant ==> rajout "1"+dernierTermeDeLaChaine
				 */
				if (i == ui.length()-1) {
					uiSuivant = uiSuivant + String.valueOf(cpt) + ui.charAt(i);
				}else {
					/*
					 * cas general
					 * pas au debut, pas à la fin et terme differnt de sauvegarde   
					 * ???
					 */
					terme = ui.charAt(i);
					cpt = 1;
				}
				
				
				/*
				 * Si on n'est pas au premier terme de la chaine =>
				 * incrementation de uiSuivant et reinitiatisation du cpt
				 */
				if(i > 0) {
					uiSuivant = uiSuivant + String.valueOf(cpt) + ui.charAt(i-1);
					cpt = 1;
				}
				
				
			}
		}
		return uiSuivant;
	}
				
	
	public static void main(String[] args) {
		
		String ui = "1";
		System.out.println("Bonjour voici les 10 premiers termes de la suite des fourmis: \n");
		
		System.out.println("U0 =" + ui);
		
		for (int i = 0; i < (10-1); i++) {
			/*
			 * appel de la fonction permettant de "calculer" le terme suivant
			 * et stockage dans la variable ui
			 */
			ui = next(ui);
			System.out.println("U" + String.valueOf(i+1) + "= " + ui);
		}
	}
	
}