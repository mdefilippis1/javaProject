package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import java.lang.Object;
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


public class ClassTestSimulateur{

  public static void main(String[] args) throws Throwable,NomDEntiteDejaUtiliseDansLeMondeException,IOException{



    Simulateur sim = new Simulateur(new BufferedReader(new FileReader("./fichier")));

    sim.executerUntour();


  }
}
