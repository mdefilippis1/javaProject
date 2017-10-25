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
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Monstre;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteFermeException;
public class ClassTestMonstre{

  public static void main(String[] args) throws NomDEntiteDejaUtiliseDansLeMondeException,ObjetAbsentDeLaPieceException,ObjetNonDeplacableException,ObjetNonPossedeParLeVivantException,PorteInexistanteDansLaPieceException,PorteFermeException{

    Monde monde = new Monde("mondeTest");

    Piece piece = new Piece("donjon",monde);
    Piece piece2 = new Piece("couloir",monde);
    Porte porte = new Porte("trappe",monde,piece,piece2);
    PiedDeBiche pied = new PiedDeBiche("pied1",monde);
    PiedDeBiche pied2 = new PiedDeBiche("pied2",monde);
    Monstre m = new Monstre("monstre1",monde,10,10,piece,pied2);
    piece2.deposer(pied);
    System.out.println(piece.toString());
    System.out.println(m.toString());
    m.executer();
    System.out.println(m.toString());
  }

}
