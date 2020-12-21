package koudous.akdar.tp1;

public class MotsCroises {
	
	
	// variables d'instances
		//public int hauteur, largeur ;
		//public String [][] tab; 
		
		private Grille solution ;
		private Grille proposition ;
		private Grille horizontal ;
		private Grille vertical ;
	
	public MotsCroises() {
		// TODO Auto-generated constructor stub
	}
	
	public MotsCroises(int hauteur, int largeur) 
	{
		assert hauteur >= 0 &&  largeur >= 0: "la taille du tableau ne peut etre negatif";
		
		this.solution = new Grille(hauteur, largeur);
		this.proposition = new Grille(hauteur, largeur);
		this.horizontal = new Grille(hauteur, largeur);
		this.vertical = new Grille(hauteur, largeur);
	}
	
	public int getHauteur()
	{
		return solution.getHauteur();
	}
	
	public int getLargeur()
	{
	    return solution.getLargeur();
	}
	
	public boolean coordCorrectes(int lig, int col)
	{
		return solution.coordCorrectes(lig, col);
	}
	
	public boolean estCaseNoire(int lig, int col)
	{
		assert coordCorrectes(lig, col);
		return solution.getCellule(lig, col)==null;
	}
	
	public void setCaseNoire(int lig, int col, boolean noire)
	{
		if (noire)
		{
			solution.setCellule(lig, col, null);
		}
		else
		{
			solution.setCellule(lig, col, " ");
		}
	}
	
	public char getSolution(int lig, int col)
	{
		assert coordCorrectes(lig, col);
		assert !estCaseNoire(lig, col);
		return solution.getCellule(lig, col).charAt(0);
	}
	
	
	public void setSolution(int lig, int col, char sol)
	{
		assert coordCorrectes(lig, col);
		assert !estCaseNoire(lig, col);
		solution.setCellule(lig, col, String.valueOf(sol));
	}
	
	public char getProposition(int lig, int col)
	{
		assert coordCorrectes(lig, col);
		assert !estCaseNoire(lig, col);
		return proposition.getCellule(lig, col).charAt(0);
	}
	
	
	public void setProposition(int lig, int col, char prop)
	{
		assert coordCorrectes(lig, col);
		assert !estCaseNoire(lig, col);
		proposition.setCellule(lig, col, String.valueOf(prop));
	}
	
	public String getDefinition (int lig, int col, boolean horiz)
	{
		assert coordCorrectes(lig, col);
		assert !estCaseNoire(lig, col);
		if (horiz) 
		{
			return horizontal.getCellule(lig, col);
		}
		else 
		{
			return vertical.getCellule(lig, col);
		}
	}
		
		public void setDefinition (int lig, int col, boolean horiz, String def)
		{
			assert coordCorrectes(lig, col);
			assert !estCaseNoire(lig, col);
			if (horiz) 
			{
				horizontal.setCellule(lig, col, def);
			}
			else 
			{
				vertical.setCellule(lig, col, def);
			}
		
	}
	
}
















