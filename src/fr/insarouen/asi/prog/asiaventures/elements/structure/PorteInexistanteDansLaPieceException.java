package fr.insarouen.asi.prog.asiaventures.elements.structure;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PieceException;

public class PorteInexistanteDansLaPieceException extends PieceException{
  public PorteInexistanteDansLaPieceException(){

  }

  public PorteInexistanteDansLaPieceException(String msg){
    super(msg);
  }
}
