package fr.insarouen.asi.prog.asiaventures;

import org.junit.Before;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.EntiteDejaDansUnAutreMondeException;


public class TestMonde{
  public Monde monde;
  public Entite entite;



  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde1");
    entite = new Entite("entite1",monde){};

  }

  @Test
  public void testConstructeurMonde(){
    assertThat(monde.getNom(), IsEqual.equalTo("monde1"));

  }

  @Test
  public void testGetEntite(){
    assertThat(entite,IsEqual.equalTo(monde.getEntite("entite1")));
  }

  @Test (expected=EntiteDejaDansUnAutreMondeException.class)
  public void testExceptionAutreMonde() throws EntiteDejaDansUnAutreMondeException,NomDEntiteDejaUtiliseDansLeMondeException{
    Monde monde2 = new Monde("monde2");
    monde2.ajouter(entite);
  }

}
