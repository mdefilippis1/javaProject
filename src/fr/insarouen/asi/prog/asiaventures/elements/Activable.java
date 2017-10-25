package fr.insarouen.asi.prog.asiaventures.elements;


import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationException;
/**
* <b> Activable.java </b>
* <p>
* C'est une classe interface, qui contient les methodes suivantes :
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.0
* <p/>
* @since 08/02/2017
*/



public interface Activable{

 /**
  * Cette methode montre si l'activation est possible avec un certain objet.
  *
  * @param obj
  * @return boolean, false si ce n'est pas activable avec un certain objet, true sinon.
  */
  
  boolean activableAvec(Objet obj);

 /**
  * Cette methode permet d'activer un certain objet.
  *
  */
  
  void activer() throws ActivationException;

 /**
  * Cette methode permet d'activer avec un certain objet.
  *
  * @param obj
  */

  void activerAvec(Objet obj) throws ActivationException;
}
