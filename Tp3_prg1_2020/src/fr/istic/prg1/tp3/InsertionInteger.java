package fr.istic.prg1.tp3;

import java.util.Scanner;

public class InsertionInteger {
	
	private static final int SIZE_MAX = 10;
	
	/**
	 * nombre entier présents dans t, 0 <= size <= SIZE_MAX
	 */
	private int size;
	private int[] array =new int [SIZE_MAX];
	public InsertionInteger() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return copie de la partie remplie du tableau
	 * 
	 * size est le nombre d'élement du petit tableau
	 * 
	 * tant qu'on est pas à la fin de size alors, on copie array ds t
	 */
	public int [] toArray() {
		int t [] = new int [size] ;
		for (int i = 0; i < size; i++) {
			t[i]=array[i];
		}
		return t;
	}
	
	
	
	
	/**
	 * fonction qui cherche si value est déjà dans le tab array
	 * 
	 * isInArray:
	 * @param value
	 * @return -1 si contient dejà la valeur,
	 * 		   la place du PREMIER element SUPERIEUR à value si value n'est pas dans le tableau
	 * 		   (autrement dit, la place que doit occuper value si il est dans le tab)
	 */
	public int isInArray(int value) {
		// Parcours la partie rempli du tableau
		
		for (int i = 0; i < size; i++) {
			
			/*
			 *test si la valeur à insérer est déjà dans le tableau 
			 */
			if (array[i] == value) {
				return -1;
			}
			
			/*
			 * test si le terme i du tableau est le PREMIER SUPERIEUR à la valeur value
			 * que l'on veut insérer dans le tab array
			 */
			if (array[i] > value) {
				return i;
			}

		}
		
		/*
		 * sinon si on a testé toute les valeur du tableau et il n'y a pas de terme
		 * qui soit SUPERIEUR à value alors, on retourne la taille du tableau
		 */
		return size;
		
	}


	/**
	 * si x n'appartient pas à array[0..size-1] et size < SIZE_MAX,
	 * size est incrémenté de 1, x est inséré dans array et les entiers
	 * array[0..size] sont trié par odre croissant.
	 * sinon array est inchangé.
	 * 
	 * Exemple:
	 * pour x=5, size=3, array[0]=1, array[1]=6, array[2]=8
	 * l'insertion délivren true, size=4
	 * array[0]=1, array[1]=5, array[2]=6, array[3]=8
	 * 
	 * @param value
	 * 		  valeur à insérer
	 * @pre les valeurs de array[0..size-1] sont triées par odre croissant
	 * 
	 * @return	false si x appartient à array[0..size-1] ou si array est complètement rempli;
	 * 			true si x n'appartient pas à array[0..size-1]
	 */
	public boolean insert(int value) {
		
		/*
		 * 1er cas: array est vide donc value est le premier element, alors
		 * on fais une insertion sans test.
		 */
		if (size == 0) {
			array[size]=value;
			size +=1;
		}
		
		/*
		 * 2eme cas: array contient dejà d'autres valeurs
		 */
		else {
			/*
			 *on recupère la position du premier elm non vide
			 */
			int position = isInArray(value);
			
			
			/*
			 * si le tab array est déjà plein ou que l'element que l'on veux inserer
			 * est  déjè dans le tab on return false.
			 */
			if (size ==  SIZE_MAX || position == -1) {
				return false;
			}
			
			
			/*
			 * pour le cas general, on parcours le tab, puis on fais un decalage vers la droite
			 * d'une place de chaque element à partir de la place exacte ou value sera placé
			 */
			
			/*
			 * on décale le tableau à droite à partir de position 
			 */
			for (int i = size-1; i >= position; i--) {
				array[i+1] = array[i]; 
			}
			
			/*
			 * on insert la valeur value puis on incrémente le tableau
			 */
			array[position] = value;
			size +=1;
		}
		return true;
	}
	
	
	
	/**
	 * array est rempli, par ordre croissant, en utilisant la fonction insert avec les valeurs lues par scanner
	 * 
	 * @param scanner
	 */
	public void createArray(Scanner scanner) {
		
		size =0; // On initialise toujours size à 0 pour chaque nouvelle saisie de de série d'entier.
		
		System.out.println("Veuillez saisir une suite d'entiers terminer par -1");
		int valSaisie = scanner.nextInt();
		
		while (valSaisie != -1) {
			insert(valSaisie);
			valSaisie = scanner.nextInt();
		}
		scanner.close();
	}
	
	
	/**
	 * @return sous forme de string le tableau sous la forme: /nb1 /nb2 /nb3 /...
	 */
	@Override
	public String toString() {
		
		String lstNb = "Liste ordoné des chiffres après retrait des doublons : \n| ";
		
		// Parcours de la partie remplie du tableau
		
		for (int i = 0; i < size; i++) {
			lstNb = lstNb + String.valueOf(array[i]) + "|";
		}
		return lstNb;
	}
	
	
	
	/**
	 * 
	 * @param args: l'argument en cours d traitement dans la ligne de commande
	 */
	public static void main(String[] args) {
		
		InsertionInteger InsInt = new InsertionInteger();
		
		Scanner sc = new Scanner(System.in);
		
		InsInt.createArray(sc);
		System.out.println(InsInt.toString());
		sc.close();
	}
	
	
}