package fr.istic.prg1.tp3;

//import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.validator.PublicClassValidator;

public class InsertionPair {
	
	private static final int SIZE_MAX = 10;
	/**
	 * nombre maximal de doublets présents dans t, 0 <= size <= SIZE_MAX
	 */
	private int size;
	private Pair[] array = new Pair [SIZE_MAX];
	
	
	
	/**
	 * @return copie de la partie remplie du tableau
	 * 
	 * size est le nombre d'élement du petit tableau
	 * 
	 * tant qu'on est pas à la fin de size alors, on copie array ds t
	 */
	public Pair [] toArray() {
		Pair [] t = new Pair [size] ;
		for (int i = 0; i < size; i++) {
			t[i]=array[i];
		}
		return t;
	}
	
	
	
	
	/**
	 * fonction qui cherche si la paire d est déjà dans le tab array
	 * 
	 * isInArray:
	 * @param d
	 * @return -1 si contient dejà la valeur,
	 * 		   la place du PREMIER element SUPERIEUR à value si value n'est pas dans le tableau
	 * 		   (autrement dit, la place que doit occuper value si il est dans le tab)
	 */
	public int isInArray(Pair d) {
		// Parcours la partie rempli du tableau
		//int  
		
		for (int i = 0; i < size; i++) {
			
			/*
			 *test si la paire d à insérer est déjà dans le tableau 
			 */
			int resComparaison = d.compareTo(array[i]); //on recup le res de la comparason de compareTo
			if (resComparaison == 0) {
				return -1;
			}
			
			/*
			 * test si la pair i du tableau est la PREMIERE PAIR SUPERIEURE à la pair d
			 * que l'on veut insérer dans le tab array
			 */
			if (resComparaison == 1) {
				System.out.println("aaaas");

				//return i;
				return i;
			}

		}
		
		
		/*
		 * sinon si on a testé toute les pair du tableau et il n'y a pas de pair
		 * qui soit SUPERIEUR à la pair d alors, on return size, la taille du tableau
		 * soit la position qu'occupera la pair d dans le tab array
		 */
		System.out.println(" kssjk");
		return size-1 ;
		
		
	}

	
	

	/*
	 * renvoyer la position exacte ou on doit faire l'insertion
	 * 
	 * Compare la paire d en paramètre avec l'élément courant i du tableau. Si d est supérieur, incrementer la variable de position.
	 * Si d est égal, renvoie -1. Si d est inférieur, renvoie index actuel - 1
	 * 
	 */
	int res;

	public int comparateur(Pair d) {
		
		int position = isInArray(d);
		
		
		for (int i = 0; i < size; i++) {
			int resComparaison = d.compareTo(array[i]); //on recup le res de la comparason de compareTo	
			if (resComparaison == -1) {
				res = position-1;
			}else if (resComparaison == 0) {
				res = -1;
			}else {
				res = position + 1;
			}
		}
		return res;
	}
	
	
	
	/**
	 * 
	 */
	public int getPosition(Pair d) {
		
		int position = 0;
		int resComparaison = 0;
		
		for (int i = 0; i < size; i++) {
			resComparaison = d.compareTo(array[i]);
			if (resComparaison == -1) { // this est inf à d
				position = i;
				break;
			}else if (resComparaison == 0) { // d egale a this
				position = -1;
				break;
			}else {
				position = i + 1; // continue le parcout pour savoir si d'autres array[i] sont plus grand
			}
		}
		return position;
	}
	
	

	/**
	 * 
	 * @param d
	 * 		  pair à insérer
	 * @pre les pair de array[0..size-1] sont triées par odre croissant
	 * 
	 * @return	false si d appartient déjà à array[0..size-1] ou si array est complètement rempli;
	 * 			true si d n'appartient pas à array[0..size-1]
	 */

	public boolean insert(Pair d) {
		
		/*
		 * 1er cas: array est vide donc d est la premiere pair, alors
		 * on fais une insertion sans test.
		 */
		//if (size == 0) {
		//	array[size]=d;
		//	size +=1;
		//}
		
		/*
		 * 2eme cas: array contient dejà d'autres valeurs
		 */
		//else {
			/*
			 *on recupère la position du premier elm non vide
			 */
		int position = getPosition(d);
		
		
		/*
		 * si le tab array est déjà plein ou que la pair que l'on veux inserer
		 * est  déjà dans le tab on return false.
		 */
		if (size ==  SIZE_MAX || position == -1) {
			return false;
		}
		
		
		/*
		 * pour le cas general, on parcours le tab, puis on fais un decalage vers la droite
		 * d'une position de chaque element à partir de la position exacte ou d sera placé
		 */
		System.out.println("position = " + position);
		System.out.println("size = " + size);
		
		/*
		 * on décale le tableau à droite à partir de position 
		 */
		for (int i = size-1; i >= position; i--) {
			System.out.println("i = " + String.valueOf(i));
			/*
			 * if (array[i+1] == null) { System.out.println(" vvvvv"); }
			 */
			array[i+1] = array[i]; 
			/*
			 * if (array[i+1] == null) { System.out.println("fffff"); }
			 * System.out.println(this.toString());
			 */
		}
		
		/*
		 * on insert la valeur value puis on incrémente le tableau
		 */
		array[position] = d;
		System.out.println(this.toString());
		size +=1;
		//}
		return true;
	}

	
	
	/**
	 * array est rempli, par ordre croissant, en utilisant la fonction insert avec les valeurs lues par scanner
	 * 
	 * @param scanner
	 *
	 */
	public void createArray(Scanner scanner) {
		
		size =0; // On initialise toujours size à 0 pour chaque nouvelle saisie de de série d'entier.
		int valueX = 0;
		int valueY = 0;
		
		System.out.println("Veuillez saisir une suite de paire d'entiers terminer par -1");
		while (valueX != -1  &&  valueY != -1) {
			
			valueX = scanner.nextInt();
			if (valueX != -1) {
				valueY = scanner.nextInt();
				Pair d = new Pair(valueX, valueY);
				
				if (d.x < -1  ||  d.y < -1) {
					System.out.println("entrer des valeurs positives");
				}else if (d.x == -1  ||  d.y == -1) {
					
				}else if (d.x > -1  ||  d.y > -1) {
					insert(d);
				}
			}
		}
		scanner.close();
	}
	
	
	
	/**
	public void createArray(Scanner scanner) {
		
		size = 0;
		System.out.println("Veuillez saisir une suite de paire d'entiers terminer par -1");
		int value = scanner.nextInt();
		int stockage = -1;
		
		while (value != -1) {
			if (stockage == -1) {
				stockage = value;
				value = scanner.nextInt();
				
				if (value != -1) {
					Pair d = new Pair(stockage, value);
					insert(d);
				}
			} else {
				stockage = -1;
				value = scanner.nextInt();
			}
		}
		scanner.close();
	}
	*/
	
	
	/**
	 * @return sous forme de string le tableau sous la forme: /nb1 /nb2 /nb3 /...
	 */
	@Override
	public String toString() {
		
		String lstPair = "Liste ordoné des chiffres après retrait des doublons : \n| ";
		
		// Parcours de la partie remplie du tableau
		
		for (int i = 0; i < size; i++) {
			lstPair = lstPair + array[i] + "|";
		}
		return lstPair;
	}
	
	
	
	/**
	 * 
	 * @param args: l'argument en cours d traitement dans la ligne de commande
	 */
	public static void main(String[] args) {
		System.out.println(" hello");
		InsertionPair InsPair = new InsertionPair();
		
		Scanner sc = new Scanner(System.in);
		
		InsPair.createArray(sc);
		System.out.println(InsPair.toString());
		sc.close();
	}
	
	
	
	
	
}