package fr.insarouen.asi.prog.asiaventures.elements.vivants;

import java.util.*;
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
import fr.insarouen.asi.prog.asiaventures.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.Executable;

/**
* <b> La classe Vivant hérite de la classe Entite. </b>
* <p>
* Un Vivant est caractérisé par les information suivantes :
* <ul>
* <li> Nom; </li>
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
* @version 1.0
* <p/>
* @since 08/02/2017
*/

public abstract class Vivant extends Entite implements Serializable{

  /**
  * Les pointVie d'un Vivant (un entier).
  *
  * @see Vivant#getPointVie()
  */

  private int pointVie;

  /**
  * Les pointForce d'un Vivant (un entier). Ce attribut n'est pas modifiable.
  *
  * @see Vivant#getPointForce()
  */

  private int pointForce;

  /**
  * La piece où se trouve le Vivant.
  *
  * @see Piece
  * @see Vivant#getPiece()
  */

  private Piece piece;

  /**
  * L'attribut objets répresent la liste d'objets possédés par le Vivant. Cette liste est changeable.
  * De plus la liste des objets est créée vide.
  * <p> Il est possible d'ajouter ou de retirer des objets de la Piece. </p>
  * @see Vivant#prendre(Objet)
  * @see Vivant#prendre(nomObjet)
  * @see Vivant#deposer(Objet)
  * @see Vivant#deposer(nomObjet)
  */

  private Map<String,Objet> objets = new TreeMap<String,Objet>();

/**
  * Constructeur Vivant
  * <p>
  * Pour la construction d'un Vivant, on accède aux attributs de la classe mère.
  * </p>
  *
  * @param _nom
  *            Le nom du Vivant.
  * @param _monde
  *            Le monde du Vivant.
  * @param _pointVie
  *            Les points de Vie du Vivant.
  * @param _pointForce
  *            Le points de force du Vivant.
  * @param _objets
  *            La liste des objets du Vivant.
  *
  * @see ElementStructurel
  */

  public Vivant(String _nom, Monde _monde, int _pointVie, int _pointForce,Piece _piece, Objet... _objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde);
    pointVie = _pointVie;
    pointForce = _pointForce;
    piece = _piece;
    int i;
    for(i=0;i<_objets.length;i++){
      Objet o = objets.put(_objets[i].getNom(),_objets[i]);
    }

    piece.entrer(this);
  }

 /**
  * Retourne true si le Vivant posède un certain Objet, obj.
  *
  * @param obj
  *  l'objet
  * @return Un boolean, false si l'objet n'est pas présent dans la liste et true sinon.
  * @see Objet
  * @see Objet#getNom()
  * @see Vivant#possede(String)
  */

  public boolean possede(Objet obj){
    return possede(obj.getNom());
  }

 /**
  * Retourne true si le Vivant posède un certain Objet.
  *
  * @param nomObj
  * @return Un boolean, false si l'objet n'est pas présent dans la liste et true sinon.
  * @see Objet#getNom()
  */

  public boolean possede(String nomObj){
    return objets.containsKey(nomObj);
  }

 /**
  * Depose un Objet dans la Piece et enlever de la liste des objets du Vivant.
  *
  * @param objet
  *              L'Objet à deposer.
  * @see Objet
  * @see Objet#getNom()
  * @see Vivant#deposer(String)
  */
  public void deposer(Objet objet) throws ObjetNonPossedeParLeVivantException{
    deposer(objet.getNom());

    }

 /**
  * Depose un Objet dans la Piece et enlever de la liste des objets du Vivant.
  *
  * @param nomObj
  *              Le nom de l'Objet à deposer.
  * @see Objet#getNom()
  * @see Piece#deposer(Objet)
  */

  public void deposer(String nomObj) throws ObjetNonPossedeParLeVivantException{
    if (this.possede(nomObj)){


      Objet o = objets.remove(nomObj);

      piece.deposer(o);

    }
    else{
      throw new ObjetNonPossedeParLeVivantException(this.getNom() + " ne possede pas l'objet " + nomObj );
    }

  }

 /**
  * Retourne l'Objet à partir de son nom (s'il éxiste dans la liste).
  *
  * @param nomObjet
  * @return L'Objet (s'il est présent dans la liste) et null sinon.
  * @see Objet
  * @see Objet#getNom()
  */

  public Objet getObjet(String nomObjet) throws ObjetNonPossedeParLeVivantException{
    if(!(this.possede(nomObjet))){
      throw new ObjetNonPossedeParLeVivantException(this.getNom()+" ne possede pas l'objet "+nomObjet);
    }

    return objets.get(nomObjet);
  }

 /**
  * Retourne la Piece où se trouve le Vivant.
  *
  * @return Piece.
  * @see Piece
  */


  public Piece getPiece(){
    return this.piece;
  }

 /**
  * Retourne pointVie du Vivant.
  *
  * @return Une entier (pointVie).
  */

  public int getPointVie(){
    return pointVie;
  }

 /**
  * Retourne pointForce du Vivant.
  *
  * @return Une entier (pointForce).
  */

  public int getPointForce(){
    return pointForce;
  }

 /**
  * Ajoute un Objet dans la liste d'objets du Vivant et enleve cet Objet de la Piece.
  *
  * @param nomObj
  *              Le nom de l'Objet à prendre.
  * @see Objet#getNom()
  * @see Piece#contientObjet(String)
  * @see Piece#retirer(String)
  */

  public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
      Objet objetPris = piece.retirer(nomObj);
      Objet o = objets.put(nomObj,objetPris);

  }


 /**
  * Ajoute un Objet dans la liste d'objets du Vivant et enleve cet Objet de la Piece.
  *
  * @param obj
  *              Le nom de l'Objet à prendre.
  * @see Objet#getNom()
  * @see Vivant#prendre(String)
  */

  public void prendre(Objet obj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{

    prendre(obj.getNom());

  }

 /**
  * Permet d'activer avec un certain Activable.
  *
  * @param activable
  * @see Activable#activer()
  */

  public void activerActivable(Activable activable) throws ActivationException{
    activable.activer();
  }

/**
  * Permet d'activer un Activable avec un certain objet.
  *
  * @param activable
  * @param objet
  * @see Activable#activerAvec(Objet)
  */

  public void activerActivableAvecObjet(Activable activable, Objet objet) throws ActivationException{
    activable.activerAvec(objet);
  }

/**
  * Permet de franchir une porte.
  *
  * @param nomPorte
  * @see Vivant#getPiece()
  * @see Porte#getEtat()
  * @see Piece#sortir(Vivant)
  * @see Piece#getPorte(String)
  * @see Porte#getPieceAutreCote(Piece)
  * @see Piece#entrer(Vivant)
  */

  public void franchir(String nomPorte) throws PorteFermeException,PorteInexistanteDansLaPieceException{

    if (!(this.getPiece().aLaPorte(nomPorte))){
      throw new PorteInexistanteDansLaPieceException("la porte "+nomPorte+" n'est pas dans la piece");
    }

    if (this.getPiece().getPorte(nomPorte).getEtat()==Etat.FERME){
      throw new PorteFermeException(nomPorte+" est fermee");
    }

    try{
      this.getPiece().sortir(this);
      this.getPiece().getPorte(nomPorte).getPieceAutreCote(this.getPiece()).entrer(this);
      this.piece = this.getPiece().getPorte(nomPorte).getPieceAutreCote(this.getPiece());
    }
    catch(VivantAbsentDeLaPieceException e){
      e.printStackTrace();
      System.out.println("vivant pas dans la piece "+this.getPiece().getNom()+", porte "+nomPorte+" non franchie");
      System.exit(0);
    }

  }

/**
  * Permet de franchir une porte.
  *
  * @param porte
  * @see Vivant#franchir(String)
  */

  public void franchir(Porte porte) throws PorteFermeException,PorteInexistanteDansLaPieceException{
    franchir(porte.getNom());

  }

/**
  * Permet de changer les points de vie du vivant.
  *
  * @param nouveauxPDV
  */

  public void setPointDeVie(int nouveauxPDV){
    this.pointVie = nouveauxPDV;
  }

/**
  * Permet d'obtenir la liste des objets detenues par le vivant.
  *
  * @return Une liste des objets
  */

  public Collection<Objet> getObjets(){
    return this.objets.values();
  }



 /**
  * Retourne les information sur le Vivant.
  *
  * @return Le nom du Vivant, la piece où il se trouve, les PV, les PF et les objets qu'il posède sous forme d'une chaine de caractères.
  * @see Vivant
  * @see Vivant#getNom()
  * @see Vivant#getPiece()
  * @see Vivant#getPointVie()
  * @see Vivant#getPointForce()
  * @see Objet#getNom()
  */


  public String toString(){
    StringBuilder res = new StringBuilder();
    res.append("\n");
    res.append("nom : ");
    res.append(this.getNom());
    res.append("\nPiece : ");
    res.append(this.getPiece().getNom());
    res.append("\nPV : ");
    res.append(this.getPointVie());
    res.append("\nForce : ");
    res.append(this.getPointForce());
    res.append("\nobjets : ");
    if (objets.isEmpty()) {
      res.append("pas d'objets");
    }
    else{
      for(String s : objets.keySet()){
        res.append("\n"+s);
      }

    }

return res.toString();

}
}
