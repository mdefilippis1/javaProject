package fr.insarouen.asi.prog.asiaventures.elements.structure;

import org.junit.Before;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ObjetAbsentDeLaPieceException;


public class TestPiece{
  public Monde monde;
  public Piece piece;
  public PiedDeBiche pied;
  public PiedDeBiche pied2;
  public Vivant vivant;


  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    monde = new Monde("monde1");
    piece = new Piece("piece1",monde);
    pied = new PiedDeBiche("pied1",monde);
    pied2 = new PiedDeBiche("pied2",monde);
    vivant = new Vivant("perso",monde,1,5,piece,pied2){};
  }

  @Test
  public void testConstructeurPiece(){
    assertThat(piece.getNom(), IsEqual.equalTo("piece1"));
    assertThat(piece.getMonde(), IsEqual.equalTo(monde));


  }

  @Test
  public void testDeposer(){
    assertThat(piece.contientObjet(pied),is(false));
    piece.deposer(pied);
    assertThat(piece.contientObjet(pied),is(true));
  }

  @Test
  public void testRetirer() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{

    piece.deposer(pied);
    assertThat(piece.contientObjet(pied),is(true));
    piece.retirer(pied);
    assertThat(piece.contientObjet(pied),is(false));
  }

  @Test
  public void testContientVivant(){
    assertThat(piece.contientVivant(vivant),is(true));


  }

  @Test (expected = ObjetAbsentDeLaPieceException.class)
  public void testObjetAbsent() throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
    piece.retirer(pied);


  }
}
