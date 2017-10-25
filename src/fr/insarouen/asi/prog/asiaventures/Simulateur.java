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
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Monstre;
import fr.insarouen.asi.prog.asiaventures.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.CommandeImpossiblePourLeVivantException;

/**
* <b> La classe Simulateur permet de simuler le jeu. </b>
* <p>
* Un Simulateur est caractérisé par les information suivantes:
* <ul>
* <li> Monde; </li>
* <li> Liste des conditions. </li>
* </ul>
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.1
* <p/>
* @since 22/04/2017
*/

public class Simulateur{

/**
  * Le Monde ou l'action se passe.
  *
  * @see Monde
  */

  private Monde monde;

/**
  * La liste des conditions du fin.
  *
  */


  private List<ConditionDeFin> conditions = new ArrayList<ConditionDeFin>();

  private EtatDuJeu etatDuJeu;

/**
  * Constructeur Simulateur
  * <p>
  * A la construction d'un Simulateur, on initialise le monde du jeu.
  * </p>
  *
  * @param ois
  *
  * @see Monde
  */

  public Simulateur(ObjectInputStream ois) throws IOException, ClassNotFoundException{
    monde = (Monde) ois.readObject();

    etatDuJeu = EtatDuJeu.ENCOURS;
  }

  private EtatDuJeu transformerStringEnEtatDuJeu(String nom){
    switch (nom){
      case "ENCOURS" : return EtatDuJeu.ENCOURS;
      case "ECHEC" : return EtatDuJeu.ECHEC;
      case "SUCCES" : return EtatDuJeu.SUCCES;
    }
    return EtatDuJeu.ENCOURS;
  }

  public Simulateur(Reader reader) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
    etatDuJeu = EtatDuJeu.ENCOURS;
    Scanner sc = new Scanner(reader);




    while (sc.hasNext()){

      switch (sc.next()) {
        case "Monde" : this.monde = new Monde(sc.next());
        break;
        case "Piece" : new Piece(sc.next(),monde);
        break;
        case "PorteSerrure" : new Porte(sc.next(),monde,new Serrure(monde),(Piece) monde.getEntite(sc.next()),(Piece) monde.getEntite(sc.next()));
        break;
        case "Porte" : new Porte(sc.next(),monde,(Piece) monde.getEntite(sc.next()),(Piece) monde.getEntite(sc.next()));
        break;
        case "Clef" : String nomDeLaCle = sc.next();
        ((Piece) monde.getEntite(sc.next())).deposer(((Porte) monde.getEntite(nomDeLaCle)).getSerrure().creerClef());
        break;
        case "JoueurHumain" : new JoueurHumain(sc.next(),monde,sc.nextInt(),sc.nextInt(),(Piece) monde.getEntite(sc.next()));
        break;
        case "ConditionDeFinVivantDansPiece" : this.conditions.add(0, new ConditionDeFinVivantDansPiece(transformerStringEnEtatDuJeu(sc.next()),(Vivant) monde.getEntite(sc.next()),(Piece) monde.getEntite(sc.next())));
        break;


      }



    }


  }


  public void enregistrer(ObjectOutputStream oos) throws IOException{
    oos.writeObject(monde);


  }

  public EtatDuJeu executerUntour() throws Throwable{
    Collection<Executable> executables = monde.getExecutables();
    for(Executable exec : executables){
      if(exec instanceof JoueurHumain){
        System.out.println(" \n ordre pour le joueur " + ((JoueurHumain)exec).getNom()+ " : \n");
        Scanner sc = new Scanner(System.in);
        ((JoueurHumain)exec).setOrdre(sc.nextLine());


      }
      for(Executable exec1 : executables){
        if(exec1 instanceof JoueurHumain){
          try{
            ((JoueurHumain)exec1).executer();
          }
          catch (CommandeImpossiblePourLeVivantException e) {
            System.out.println(e.getMessage());
            

          }
        }

      }

      for(Executable exec2 : executables){
        if(exec2 instanceof Monstre){
          ((Monstre)exec2).executer();
        }

      }

      for(ConditionDeFin c : this.conditions){
        if (c.verifierCondition()!=EtatDuJeu.ENCOURS){
          return c.verifierCondition();
        }
      }

    }

    return EtatDuJeu.ENCOURS;
  }

  public EtatDuJeu executerJusquALaFin() throws Throwable{
    EtatDuJeu res = EtatDuJeu.ENCOURS;
    while (res==EtatDuJeu.ENCOURS){
      res = this.executerUntour();
    }
    return res;

  }

  public EtatDuJeu getEtatDuJeu(){
    return this.etatDuJeu;
  }


}
