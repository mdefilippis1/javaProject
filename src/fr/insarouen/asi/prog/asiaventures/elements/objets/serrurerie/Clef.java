package fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie;

import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;

/**
* <b> La classe finale Clef herite de la classe Objet. </b>
* <p>
* Une Clef est caracterisee par les information suivantes :
* <ul>
* <li> Nom; </li>
* <li> Monde. </li>
* </ul>
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.0
* <p/>
* @since 22/04/2017
*/

public final class Clef extends Objet implements Serializable{

/**
  * Constructeur Clef
  * <p>
  * Pour la construction d'une Clef, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param _nom
  *            Le nom d'une Clef.
  * @param _monde
  *            Le monde d'une Clef.
  */

  protected Clef(String _nom, Monde _monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde);
  }

 /**
  * Retourne true si une clef est deplacable.
  *
  * @param obj
  * @return Un boolean, false si la clef n'est pas deplacable et true sinon. Par default return true.
  */


  public boolean estDeplacable(){
    return true;
  }







}
