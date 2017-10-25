package fr.insarouen.asi.prog.asiaventures.elements.structure;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PieceException;

public class VivantAbsentDeLaPieceException extends PieceException{
  public VivantAbsentDeLaPieceException(){

  }

  public VivantAbsentDeLaPieceException(String msg){
    super(msg);
  }
}
