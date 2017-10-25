package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.Before;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestPiedDeBiche {
  public Monde monde;
  public PiedDeBiche pied;


  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde= new Monde("monde1");
    pied= new PiedDeBiche("pied1",monde);
  }

  @Test
  public void testConstructeurPied() {
    assertThat(pied.getNom(), IsEqual.equalTo("pied1"));
    assertThat(pied.getMonde(), IsEqual.equalTo(monde));
  }

  @Test
  public void testEstDeplacable() {
    assertThat(pied.estDeplacable(),is(true));
  }
}
