package fr.insarouen.asi.prog.puissance.sourcesenonce;
import java.util.Observable;
import fr.insarouen.asi.prog.puissance.sourcesenonce.Puissance4ColonneException;

public class Puissance4 extends Observable{

    private int largeur, hauteur;
    private TypeJeton[][] plateau;
    private TypeJeton tourJeton;
    public Puissance4(int _largeur, int _hauteur) {
	largeur = Math.min(_largeur,10);
	hauteur = Math.min(_hauteur,10);
	plateau = new TypeJeton[largeur][hauteur];
	for(int j=0; j<hauteur; j++)
	    for(int i=0; i<largeur; i++)
		plateau[i][j] = TypeJeton.VIDE;
	tourJeton = TypeJeton.JAUNE;
    }

    public int getLargeur() {
	return largeur;
    }

    public int getHauteur() {
	return hauteur;
    }

    public TypeJeton getJeton(int colonne, int ligne) {
	return plateau[colonne][ligne];
    }

    public TypeJeton getTour() {
	return tourJeton;
    }

    public void joueColonne(int numeroColonne) throws Puissance4ColonneException {
	if (numeroColonne<0 || numeroColonne>=largeur)
	    throw new Puissance4ColonneException("Colonne "+numeroColonne+" inexistante");
	descenteJeton(numeroColonne);
	tourJeton = (tourJeton==TypeJeton.JAUNE)?TypeJeton.ROUGE:TypeJeton.JAUNE;
  setChanged();
  notifyObservers();
    }

    private void descenteJeton(int numeroColonne) throws Puissance4ColonneException {
	for(int j=0; j<hauteur ; j++)
	    if (plateau[numeroColonne][j] == TypeJeton.VIDE) {
		plateau[numeroColonne][j] = tourJeton;
		return;
	    }
	throw new Puissance4ColonneException("Colonne pleine");
    }

    public boolean remplie(){

      for (int colonne = 0;colonne<this.getLargeur() ;colonne++ ) {
        if (this.getJeton(colonne,this.getHauteur()-1)==TypeJeton.VIDE) {
          return false;
        }
      }
      return true;

    }

}
