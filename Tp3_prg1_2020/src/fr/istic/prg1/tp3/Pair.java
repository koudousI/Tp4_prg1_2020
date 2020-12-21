//package fr.istic.prg1.tp3;

package fr.istic.prg1.tp3;



/**
 * 
 * @author Mickaël Foursov <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2015-11-10
 * 
 *        Classe représentant des doublets non modifiables
 */

public class Pair implements Comparable<Pair> {
	
	int x, y;
	
	
	/**
	 * constructeur
	 * @param x
	 * @param y
	 */
	public Pair(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	
	

	/**
	 * cloner gràce au constructeur
	 * 
	 * @return un clone de la paire de l'instance
	 */
	@Override
	public Pair clone() {
	    return new Pair(x,y);
	}

	
	
	/**
	 * @param Pair d
	 * 		  une pair d que l'on test si il est inferier a la pair de l'instance (this).
	 * 
	 * @return true si la paire de l'instance  est inferieur à la pair d
	 */
	public boolean less(Pair d) {
		
		if (this.x < d.x   || (this.x == d.x   &&  this.y < d.y)) {
			return true;
		}
		return false;
	}
	
	
	
	
	/**
	 * @param obj
	 * 		  un objet quelconque
	 * 
	 * @return true : si l'objet passée en param est le meme que l'objet de l'nstance
	 * 		   true : si l'objet passée n param est un clone de l'objet d'instance
	 * 		   false: si l'objet n'est pas de type Pair
	 * 		   false si l'objet est null
	 * 		   false: si l'objet est non null, et est de type Pair, MAIS si au moins une de 
	 * 		   ses parties est différente de l'objet d'instance 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pair)) {
			return false;
		}
		
		//Pair unePair = (Pair) obj;
		//if (this.compareTo(unePair) == 0) {
		if ((this.x == ((Pair)obj).x)  &&  (this.y == ((Pair)obj).y)) {
			return true;
		}
		return false;
	}
	
	
	
	
	/**
	 * @param Pair d
	 * 		  une pair d que l'on compare a la pair de l'instance (this).
	 * 
	 * @return -1 si d est inferieur à la pair d
	 * 			0 si d est égale à la pair de l'instance
	 * 			1 si d est supérieur a la pair de l'instance
	 */
	@Override
	public int compareTo(Pair d) {
		//-1 si d est inferieur à la pair d
		if (less(d)) {
			return -1;
		}
		
		//0 si d est égale à la pair de l'instance
		if (equals(d)) {
			return 0;
		}
		
		//1 si d est supérieur a la pair de l'instance
		return 1;
	}

	
	
	/**
	 * 
	 * @return une chaine de la forme [x,y]
	 */
	@Override
	public String toString() {
	    return "["+x+","+y+"]";
	}
	
	
	
	
	
	
}