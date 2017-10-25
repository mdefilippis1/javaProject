package fr.insarouen.asi.prog.asiaventures;

import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.ObjetNonPossedeParLeVivantException;


public class ClassTestVivant{

  public static void main(String[] args) throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException,ObjetNonPossedeParLeVivantException,NomDEntiteDejaUtiliseDansLeMondeException{

    Monde monde = new Monde("mondeTest");
    Piece piece = new Piece("piece1", monde);
    Objet objet1 = new PiedDeBiche("pied1",monde);
    Objet objet2 = new PiedDeBiche("pied2",monde);
    Objet objet3 = new PiedDeBiche("pied3",monde);

    Vivant humain = new Vivant("jean",monde,30,1,piece,objet1,objet2,objet3){

    };
    System.out.println(humain.toString());
    System.out.println(piece.toString());
    humain.deposer(objet1);
  
    System.out.println(humain.toString());


  }
}
