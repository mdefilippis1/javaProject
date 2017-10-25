package fr.insarouen.asi.prog.puissance.sourcesenonce;

import fr.insarouen.asi.prog.puissance.sourcesenonce.Puissance4;
import java.util.Observer;
import java.util.Observable;

public class VuePuissance4Txt implements Observer{

  private Puissance4 p;
  public VuePuissance4Txt(Puissance4 _p) {
    p=_p;
    p.addObserver(this);
  }

  private String jetonEnCaractere(TypeJeton jeton){
    switch (jeton){
      case JAUNE : return "O";

      case ROUGE : return "X";

      case VIDE : return "*";

      default : return "";
    }

  }
  public void afficher(){
    StringBuilder res = new StringBuilder();
    int colonne,ligne;
    for (ligne=p.getHauteur()-1;ligne>=0 ;ligne-- ) {
      for (colonne=0;colonne<p.getLargeur() ;colonne++ ) {
        res.append(jetonEnCaractere(p.getJeton(colonne,ligne)));

      }
      res.append("\n");
    }
    System.out.println(res.toString());
  }

  public void update(Observable o,Object arg){
    this.afficher();
  }


}
