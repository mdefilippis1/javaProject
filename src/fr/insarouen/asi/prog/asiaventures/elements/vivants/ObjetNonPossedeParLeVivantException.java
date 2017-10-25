package fr.insarouen.asi.prog.asiaventures.elements.vivants;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.VivantException;

public class ObjetNonPossedeParLeVivantException extends VivantException{
  public ObjetNonPossedeParLeVivantException(){

  }

  public ObjetNonPossedeParLeVivantException(String msg){
    super(msg);
  }
}
