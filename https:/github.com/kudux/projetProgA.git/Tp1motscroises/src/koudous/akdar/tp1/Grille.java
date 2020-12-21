package koudous.akdar.tp1;



public class Grille {
	// variables d'instances
	public int hauteur, largeur ;
	public String [][] tab; 
	public int taille = hauteur*largeur;
	
	
	public Grille ( ) 
	{	
		
	}
	
	public Grille (int hauteur, int largeur ) 
	{
		
		assert hauteur >= 0 &&  largeur >= 0: "la taille du tableau ne peut etre negatif";
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.tab= new String [hauteur][largeur];
		 
	}
	
	public int getHauteur()
	{
	    return hauteur;
	}
	
	public int getLargeur()
	{
	    return largeur;
	}
	
	public String [][] getTab()
	{
	    return tab;
	}
	
	public boolean coordCorrectes(int lig, int col)
	{
		return ( ( lig >=1 && lig <= getHauteur() ) && (col>=1 && col <= getLargeur()));
	}
	
	public String getCellule(int lig, int col)
	{
		assert coordCorrectes(lig, col): "coord existe";
		
		return tab[lig-1][col-1];
	}
	
	public void setCellule(int lig, int col, String ch)
	{
		assert coordCorrectes(lig, col): "coord existe";
		
		tab[lig-1][col-1]=ch;
	}
	
	public String toString() 
	{
		String w = "";
		
		for(int L=1; L<=hauteur; L++) 
		{
			String texteLigne= Integer.toString(L);
			for(int C=1; C<=largeur; C++) 
			{
				setCellule(L, C, texteLigne + ',' +Integer.toString(C));
				System.out.println(L+','+C);
			}
		}
		
		return w;
	}
	
	
	 public static void main(String[] args) 
	 {
		 Grille maGrille = new Grille (3,5);
			maGrille.toString();
	}
	 
}








