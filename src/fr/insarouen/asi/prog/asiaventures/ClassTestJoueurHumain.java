package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import java.lang.Object;
import java.lang.reflect.*;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventures.elements.Activable;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventures.elements.Etat;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.Executable;
import fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventures.Simulateur;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.CommandeImpossiblePourLeVivantException;

public class ClassTestJoueurHumain{

  public static void main(String[] args) throws CommandeImpossiblePourLeVivantException,NomDEntiteDejaUtiliseDansLeMondeException,IOException,EntiteDejaDansUnAutreMondeException,NoSuchMethodException,IllegalAccessException,InvocationTargetException{

    Monde m = new Monde("insa");
    Piece p = new Piece("magellan",m);
    Piece p2 = new Piece("dumont",m);
    Porte porte1 = new Porte("portail",m,new Serrure(m),p,p2);
    Clef cle1 = porte1.getSerrure().creerClef();
    PiedDeBiche pied = new PiedDeBiche("pied1",m);
    p.deposer(pied);
    JoueurHumain joueur = new JoueurHumain("jean", m, 10, 10, p, pied,cle1);


    System.out.println(joueur.toString());
    joueur.setOrdre("Poser pied1");
    joueur.executer();
    System.out.println(joueur.toString());


    joueur.setOrdre("Prendre pied1");
    joueur.executer();
    System.out.println(joueur.toString());

    joueur.setOrdre("Poser pied1");
    joueur.executer();
    System.out.println(joueur.toString());

    System.out.println(porte1.toString());
    joueur.setOrdre("OuvrirPorte portail clef1");
    joueur.executer();
    System.out.println(porte1.toString());



  }
}
