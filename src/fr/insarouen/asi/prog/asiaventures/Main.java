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
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;

public class Main extends Object{

  public static void afficherMenu(){
    System.out.println("\n1 : Jouer \n");
    System.out.println("2 : charger fichier \n");
    System.out.println("3 : sauvegarder \n");
    System.out.println("4 : charger \n");
    System.out.println("5 : Quitter \n");

  }


  public static void main(String[] args) throws Throwable,ClassNotFoundException,IOException,FileNotFoundException,NomDEntiteDejaUtiliseDansLeMondeException{
    Simulateur sim = new Simulateur(new BufferedReader(new FileReader("./fichierVide")));
    while(sim.getEtatDuJeu()==EtatDuJeu.ENCOURS){
    afficherMenu();
    Scanner sc = new Scanner(System.in);

    switch (sc.nextInt()) {
      case 1 :
      sim = new Simulateur(new BufferedReader(new FileReader("./fichier")));
      sim.executerUntour();
      System.out.println("\nrejouer ? 1 : oui       2 : non\n");
      Scanner sc2 = new Scanner(System.in);
      if(sc2.nextInt() == 1){
        sim.executerJusquALaFin();
      }
      else{


      }


      break;
      case 2 : sim = new Simulateur(new BufferedReader(new FileReader("./fichier")));

      break;
      case 3 :
      if(sim!=null){
        sim.enregistrer(new ObjectOutputStream(new FileOutputStream("/tmp/save00")));
      }
      else{
        System.out.println("\npas de partie en cours \n");

      }

      break;
      case 4 :
      FileInputStream fileInputStream = new FileInputStream("/tmp/save00");
      sim = new Simulateur(new ObjectInputStream(fileInputStream));
      break;
      case 5 :
        System.out.println("fin");
        System.exit(0);
        break;

    }
    }
  }
}
