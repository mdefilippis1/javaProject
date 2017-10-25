package fr.insarouen.asi.prog.asiaventures.elements;

import fr.insarouen.asi.prog.asiaventures.elements.ActivationException;

public class ActivationImpossibleException extends ActivationException{
  public ActivationImpossibleException(){

  }
  public ActivationImpossibleException(String msg){
    super(msg);
  }
}
