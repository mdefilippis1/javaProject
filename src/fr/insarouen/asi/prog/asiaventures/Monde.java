package fr.insarouen.asi.prog.asiaventures;

import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.EntiteDejaDansUnAutreMondeException;
import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.elements.Executable;


/**
* <b> La classe Monde permet de définir un certain monde avec ses propriétés. </b>
* <p>
* Un Monde est caractérisé par les information suivantes:
* <ul>
* <li> Nom; </li>
* <li> Liste d'Entites. </li>
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

public class Monde implements Serializable{

  /**
  * Le nom du Monde. Ce nom n'est pas modifiable.
  *
  * @see Monde#Monde(String)
  * @see Monde#getNom()
  */

  private String nomMonde;

  /**
  * L'attribut entites répresent la liste d'entites contenues dans le Monde. Cette liste est changeable.
  * <p> Il est possible d'ajouter des entites au Monde. </p>
  * @see Monde#Monde(String)
  * @see Monde#ajouter(Entite)
  */
  private Map<String,Entite> entites;

/**
  * Constructeur Monde
  * <p>
  * A la construction d'un Monde, on initialise la liste des entites au vide.
  * </p>
  *
  * @param nom
  *            Le nom du Monde.
  *
  * @see Entite
  */

  public Monde(String nom){
    nomMonde = nom;
    entites = new TreeMap<String,Entite>();
  }

 /**
  * Retourne le nom du Monde.
  *
  * @return Le nom d'un Monde sous forme d'une chaine de caractères.
  */

  public String getNom(){
    return nomMonde;

  }

 /**
  * Retourne l'Entite à partir de son nom (si elle existe dans le Monde).
  *
  * @param nomEntite
  * @return L'Entite (si elle est présent dans le Monde) et null sinon.
  * @see Monde
  * @see Entite#getNom()
  */

  public Entite getEntite(String nomEntite){
    return entites.get(nomEntite);
  }

 /**
  * Retourne true si une entite est present dans le monde.
  *
  * @param enti
  * @return Un boolean, false si l'entite n'est pas present dans le monde et true sinon.
  */

  public boolean estPresentDansMonde(Entite enti){
    return this.entites.containsValue(enti);
  }

 /**
  * Retourne true si un certain nom est utilise dans le monde.
  *
  * @param nom
  * @return Un boolean, false si le nom n'est pas present dans le monde et true sinon.
  */

  public boolean nomDejaDansLeMonde(String nom){
    return this.entites.containsKey(nom);
  }

  /**
   * Ajoute une Entite dans le Monde.
   *
   * @param e
   *              La nouvelle Entite à ajouter.
   * @see Entite
   * @see Monde
   */

  public void ajouter(Entite e) throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{





    if ((estPresentDansMonde(e))){
        throw new NomDEntiteDejaUtiliseDansLeMondeException("deja present dans monde");
    }

    if (!(e.getMonde()).equals(this)){
      throw new EntiteDejaDansUnAutreMondeException("autre monde");
    }

    Entite entiteAjoutee = entites.put(e.getNom(),e);


    }

    public Collection<Executable> getExecutables(){
      Collection<Entite> ent = this.entites.values();
      Collection<Executable> ex = new HashSet<Executable>();
      for (Entite e : ent){
        if (e instanceof Executable){

          ex.add((Executable) e);
        }
      }
      return ex;


    }







 /**
  * Retourne les information sur le Monde.
  *
  * @return Le nom d'un Monde et les entites qu'il contient sous forme d'une chaine de caractères.
  * @see Entite
  * @see Entite#getNom()
  * @see Monde#getNom()
  */

  

  public String toString(){

    if (entites.isEmpty()) {
      return this.getNom()+"\n";
    }
    else{
      int j;
      StringBuilder res = new StringBuilder();
      res.append(this.getNom());
      for(String s : entites.keySet()){
        res.append("\n"+s);
    }
    res.append("\n");
    return res.toString();
  }

  }


}
