package fr.insarouen.asi.prog.asiaventures.elements;


import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.EntiteDejaDansUnAutreMondeException;
import java.lang.Object;
import java.util.*;
import java.io.*;


/**
* <b> La classe abstraite Entite permet de définir une réalité avec ses propriétés. </b>
* <p>
* Une Entite est caractérisée par les information suivantes:
* <ul>
* <li> Nom; </li>
* <li> Monde. </li>
* </ul>
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.1
* <p/>
* @since 08/02/2017
*/

abstract public class Entite implements Serializable{


  /**
  * Le nom de l'Entite. Ce nom n'est pas modifiable.
  *
  * @see Entite#Entite(String, Monde)
  * @see Entite#getNom()
  */
  private String nom;

  /**
  * Le monde de l'Entite. Ce monde n'est pas modifiable.
  *
  * @see Entite#Entite(String, Monde)
  * @see Entite#getMonde()
  */
  private Monde monde;

 /**
  * Constructeur Entite
  * <p>
  * A la construction d'une Entite, on la rajoute automatiquement au monde existant.
  * </p>
  *
  * @param nom
  *            Le nom de l'Entite.
  * @param monde
  *            Le monde de l'Entite.
  *
  * @see Entite#nom
  * @see Entite#monde
  */
  public Entite(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    if (monde.nomDejaDansLeMonde(nom)){
      throw new NomDEntiteDejaUtiliseDansLeMondeException("le nom "+ nom +" est deja utilise");
    }
    this.nom = nom;
    this.monde = monde;
    try{
    this.monde.ajouter(this);
    }
    catch(EntiteDejaDansUnAutreMondeException e){
      e.printStackTrace();
      System.out.println("ne doit pas arriver");
      System.exit(0);
    }
  }

 /**
  * Retourne le nom de l'Entite.
  *
  * @return Le nom d'une Entite sous forme d'une chaine de caractères.
  */

  public String getNom(){
    return nom;

  }

 /**
  * Retourne le monde de l'Entite.
  *
  * @return Le monde où se trouve l'Entite.
  *
  * @see Monde
  */

  public Monde getMonde(){
    return monde;
  }

 /**
  * Retourne les information sur l'Entite.
  *
  * @return Le nom d'une Entite sous forme d'une chaine de caractères.
  * @see Entite
  * @see Entite#getNom()
  */

  public String toString(){
    return ("l'entite "+getNom());
  }

 /**
  * Retourne true si un certain Objet est égale à l'Entite.
  *
  * @param o
  *           L'objet comparé
  * @return Un boolean, false si l'objet possède un nom où un monde différent de l'Entite (où appartient à une autre classe) et true sinon.
  * @see Object
  * @see Object#getClass()
  */

  public boolean equals(Object o){
    if (o.getClass() != this.getClass()){
      return false;
    }
    Entite e = (Entite) o;
    return (nom.equals(e.nom)) && (monde.equals(e.monde));


  }

 /**
  * Retourne un entier signé sur 32-bit (qui représente l'instance de la classe).
  *
  * @return La valeur de hachage.
  */


  public int hashCode(){
    return 23*(nom.hashCode()+monde.hashCode());
  }


}
