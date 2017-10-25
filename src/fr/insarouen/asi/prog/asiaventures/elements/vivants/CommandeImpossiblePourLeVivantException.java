package fr.insarouen.asi.prog.asiaventures.elements.vivants;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.VivantException;

public class CommandeImpossiblePourLeVivantException extends VivantException{
  public CommandeImpossiblePourLeVivantException(){

  }

  public CommandeImpossiblePourLeVivantException(String msg){
    super(msg);
  }
}
