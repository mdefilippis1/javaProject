package fr.insarouen.asi.prog.asiaventures.elements;

import org.junit.Before;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestEntite{
  public Monde monde;
  public Entite entite;
  public Entite entite2;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde1");
    entite = new Entite("entite1",monde){};
    entite2 = new Entite("entite2",monde){};
  }

  @Test public void testConstructeurEntite(){
    assertThat(entite.getNom(), IsEqual.equalTo("entite1"));
    assertThat(entite.getMonde(), IsEqual.equalTo(monde));
  }

  @Test public void testEqualsEntite(){

    assertThat(entite.equals(entite2),is(false));
    assertThat(entite.equals(entite), is(true));
  }

  @Test public void testHashcode(){
    assertThat(entite.hashCode()==entite2.hashCode(),is(false));
    assertThat(entite.hashCode()==entite.hashCode(),is(true));

    }

  @Test (expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testExceptionNomDejaPris() throws NomDEntiteDejaUtiliseDansLeMondeException{
    Entite entite3 = new Entite("entite2",monde){};
  }





}
