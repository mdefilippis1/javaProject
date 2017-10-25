package fr.insarouen.asi.prog.asiaventures;


import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.Monde;
import  java.lang.Exception ;

public class ClassTestEntite{

  public static void main(String[] args) throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{

    Monde m = new Monde("lemonde");
    Monde m2 = new Monde("lemonde2");
    Entite e = new Entite("entitetest",m){

    };


    try{
    m2.ajouter(e);
    }
    catch(EntiteDejaDansUnAutreMondeException eee){
      eee.printStackTrace();
    }

    //try{
    //Entite e2 = new Entite("entitetesteeee",m){

    //};
    //}
    //catch(NomDEntiteDejaUtiliseDansLeMondeException eeee){
      //eeee.printStackTrace();
    //}


    //Entite e3 = new Entite("entitefausse",m){

    //};

    //System.out.println(e.toString());
    //System.out.println(e.equals(e2));
    //System.out.println(e.equals(e3));
  }




}
