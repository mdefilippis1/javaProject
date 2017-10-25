package fr.insarouen.asi.prog.asiaventures.elements.structure;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PieceException;

public class ObjetAbsentDeLaPieceException extends PieceException{
  public ObjetAbsentDeLaPieceException(){

  }

  public ObjetAbsentDeLaPieceException(String msg){
    super(msg);
  }
}
