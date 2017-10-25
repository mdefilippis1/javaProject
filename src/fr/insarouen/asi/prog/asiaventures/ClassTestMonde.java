package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Monstre;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventures.elements.Executable;

public class ClassTestMonde{

  public static void main(String[] args) throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{

    Monde m = new Monde("mondetest");

    Piece p = new Piece("magellan",m);
    Piece p2 = new Piece("dumont",m);
    Porte porte1 = new Porte("portail",m,new Serrure(m),p,p2);
    Clef cle1 = porte1.getSerrure().creerClef();
    PiedDeBiche pied = new PiedDeBiche("pied1",m);
    p.deposer(pied);
    JoueurHumain joueur = new JoueurHumain("jean", m, 10, 10, p, pied,cle1);
    Monstre monstre = new Monstre("aaa",m,10,10,p);
    Monstre monstre2 = new Monstre("21",m,10,10,p);

    Collection<Executable> exec = m.getExecutables();
    for (Executable e : exec){
      System.out.println(e.toString());
    }

  }


}
