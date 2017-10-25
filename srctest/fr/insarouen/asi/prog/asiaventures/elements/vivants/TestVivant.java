package fr.insarouen.asi.prog.asiaventures.elements.vivants;

import org.junit.Before;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.ObjetNonPossedeParLeVivantException;


public class TestVivant{
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
  public void testConstructeurVivant(){
    assertThat(vivant.getNom(), IsEqual.equalTo("perso"));
    assertThat(vivant.getMonde(), IsEqual.equalTo(monde));


  }

  @Test
  public void testPDV(){
    assertThat(vivant.getPointVie(),IsEqual.equalTo(1));
  }

  @Test
  public void testPDF(){
    assertThat(vivant.getPointForce(),IsEqual.equalTo(5));
  }

  @Test
  public void testGetPiece(){
    assertThat(vivant.getPiece(),IsEqual.equalTo(piece));
  }


  @Test
  public void testPossede(){
    assertThat(vivant.possede(pied2),is(true));
    assertThat(vivant.possede(pied),is(false));
  }

  @Test
  public void testGetObjet(){
    assertThat(vivant.getObjet("pied2"),IsEqual.equalTo(pied2));
    assertThat(vivant.getObjet("pied1"),IsEqual.equalTo(null));
  }

  @Test
  public void testDeposer() throws ObjetNonPossedeParLeVivantException{
    assertThat(vivant.possede(pied2),is(true));
    vivant.deposer(pied2);
    assertThat(vivant.possede(pied2),is(false));
  }

  @Test
  public void testPrendre() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    piece.deposer(pied);
    assertThat(vivant.possede(pied),is(false));
    vivant.prendre(pied);
    assertThat(vivant.possede(pied),is(true));
  }

  @Test (expected = ObjetNonPossedeParLeVivantException.class)
  public void testExceptionPossedePas() throws ObjetNonPossedeParLeVivantException{
    vivant.deposer(pied);
  }

  @Test (expected = ObjetAbsentDeLaPieceException.class)
  public void testExceptionObjetAbsent() throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
    vivant.prendre(pied);
  }

  





}
