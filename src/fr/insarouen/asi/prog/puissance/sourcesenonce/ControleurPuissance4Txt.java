package fr.insarouen.asi.prog.puissance.sourcesenonce;

import java.util.Observer;
import java.util.Observable;
import java.util.Scanner;

public class ControleurPuissance4Txt {

  private Puissance4 p;
  public ControleurPuissance4Txt(Puissance4 _p){
    p=_p;
  }

  public void joue(){

    while(!(p.remplie())){
    try{
      Scanner sc = new Scanner(System.in);
      System.out.println("Veuillez saisir une colonne : \n");
      int entree = sc.nextInt();
      p.joueColonne(entree);

    }
    catch(Puissance4ColonneException e){
      System.out.println(e.getMessage()+"\n");
    }
  }
  }
}
