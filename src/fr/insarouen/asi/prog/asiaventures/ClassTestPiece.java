package fr.insarouen.asi.prog.asiaventures;


import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.ObjetNonDeplacableException;

public class ClassTestPiece{

  public static void main(String[] args) throws NomDEntiteDejaUtiliseDansLeMondeException,ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{

    Monde monde = new Monde("mondetest2");
    Piece piece = new Piece("pieceTest", monde);
    //Piece piece1 = new Piece("pieceTest", monde);
    Objet objet1 = new PiedDeBiche("pied1",monde);
    Objet objet2 = new PiedDeBiche("pied2",monde);
    Objet objet3 = new PiedDeBiche("pied3",monde);
    Objet objet4 = new PiedDeBiche("pied4",monde);
    piece.deposer(objet1);
    System.out.println(piece.toString());
    piece.deposer(objet2);
    piece.deposer(objet3);
    //piece.retirer(objet4);
    System.out.println(piece.toString());

    piece.retirer("pied3");
    piece.retirer("pied3"); //je lance une exception
    System.out.println(piece.toString());

  }
}
