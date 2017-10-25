package fr.insarouen.asi.prog.asiaventures.elements.vivants;

import java.util.*;
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
import fr.insarouen.asi.prog.asiaventures.elements.vivants.CommandeImpossiblePourLeVivantException;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationImpossibleException;

/**
* <b> La classe JoueurHumain herite de la classe Vivant et implements la classe Executable. </b>
* <p>
* Un JoueurHumain est caractérisé par les information suivantes:
* <ul>
* <li> Nom; </li>
* <li> Ordre; </li>
* <li> Liste d'objets qu'il contient; </li>
* <li> Points de vie; </li>
* <li> Points de Force; </li>
* <li> Piece où il se trouvé; </li>
* <li> Monde. </li>
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

public class JoueurHumain extends Vivant implements Executable,Serializable{

  /**
  * L'action a faire.
  *
  * @see JoueurHumaint#setOrdre()
  */


  private String ordre;

/**
  * Constructeur JoueurHumain
  * <p>
  * Pour la construction d'un JoueurHumain, on accède aux attributs de la classe mère et on initialise l'action a faire a vide.
  * </p>
  *
  * @param _nom
  *            Le nom du JoueurHumain.
  * @param _monde
  *            Le monde du JoueurHumain.
  * @param _pointVie
  *            Les points de Vie du JoueurHumain.
  * @param _pointForce
  *            Le points de force du JoueurHumain.
  * @param _objets
  *            La liste des objets du JoueurHumain.
  *
  * @see ElementStructurel
  */

  public JoueurHumain(String _nom, Monde _monde, int _pointVie, int _pointForce, Piece _piece, Objet... _objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde,_pointVie,_pointForce,_piece,_objets);
    this.setOrdre("");
  }

/**
  * Permet de choisir une certain action a faire.
  *
  * @param _ordre
  */

  public void setOrdre(String _ordre){
    this.ordre = _ordre;
  }

/**
  * Permet d'executer une certain action.
  *
  * @see JoueurHumain.
  */

  public void executer() throws CommandeImpossiblePourLeVivantException{
    String[] ordreDecoupe = ordre.split(" ",3);

    String nomMethode =  "commande"+ordreDecoupe[0];

    try{
      if (ordreDecoupe.length == 2){

        Method m = this.getClass().getDeclaredMethod(nomMethode, "aaaa".getClass());
        m.invoke(this,ordreDecoupe[1]);


      }
      else{
        if (ordreDecoupe.length == 3){

          Method m = this.getClass().getDeclaredMethod(nomMethode, "aaaa".getClass(),"aaaa".getClass());
          m.invoke(this,ordreDecoupe[1],ordreDecoupe[2]);

        }
      }
    }
    catch(InvocationTargetException e){

      throw new CommandeImpossiblePourLeVivantException();
    }
    catch(NoSuchMethodException e){

      throw new CommandeImpossiblePourLeVivantException("commande innexistante");
    }
    catch(IllegalAccessException e){

      throw new CommandeImpossiblePourLeVivantException("illegal access");
    }






  }



  private void commandeVoir(String piece){
    System.out.println(this.getMonde().getEntite(piece).toString());
  }



/**
  * Permet au JoueurHumain de prendre un certain objet.
  *
  * @param nomObjet
  */

  private void commandePrendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{

    this.prendre(nomObjet);



  }

/**
  * Permet au JoueurHumain de poser un certain objet.
  *
  * @param nomObjet
  * @see Vivant
  */

  private void commandePoser(String nomObjet) throws ObjetNonPossedeParLeVivantException{
    this.deposer(nomObjet);
  }

/**
  * Permet au JoueurHumain de franchir une porte.
  *
  * @param nomPorte
  * @see Vivant
  */

  private void commandeFranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
    this.franchir(nomPorte);
  }

/**
  * Permet au JoueurHumain d'ouvrir une Porte.
  *
  * @param nomPorte
  * @see Activable
  * @see Piece
  * @see Porte
  */

  private void commandeOuvrirPorte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException{




    this.getPiece().getPorte(nomPorte).activer();


  }

/**
  * Permet au JoueurHumain d'ouvrir une Porte avec un certain objet.
  *
  * @param nomPorte
  * @param nomObjet
  * @see Activable
  * @see Piece
  * @see Porte
  */

  private void commandeOuvrirPorte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException,ObjetNonPossedeParLeVivantException{
    this.getPiece().getPorte(nomPorte).activerAvec(this.getObjet(nomObjet));
    this.getPiece().getPorte(nomPorte).activer();
  }


}
