/*
 * ControleurFeuAuto.java
 *
 * Created on 21 juin 2006, 00:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fr.insarouen.asi.prog.feux;
import fr.insarouen.asi.prog.feux.Feu;
import fr.insarouen.asi.prog.feux.Feu.Etat;

/**
 *
 * @author nicolas
 */
public class ControleurFeuAuto implements Runnable {
    private Feu feu;
    private Thread thisThread;
    private int tpsArret,tpsPasse,tpsAttention;
    boolean enCours;

    /** Creates a new instance of ControleurFeuAuto */
    public ControleurFeuAuto(Feu _feu, int _tpsPasse, int _tpsAttention, int _tpsArret) {
      feu = _feu;
      tpsArret=_tpsArret;
      tpsPasse=_tpsPasse;
      tpsAttention=_tpsAttention;
    }
     public void run(){
       thisThread = Thread.currentThread();
       enCours = true;
       while(enCours){
         try{
           switch(feu.getEtat()){
             case PASSE : feu.setEtat(Etat.ATTENTION);
             thisThread.sleep(tpsAttention);
             break;
             case ATTENTION : feu.setEtat(Etat.ARRET);
             thisThread.sleep(tpsArret);
              break;
             case ARRET : feu.setEtat(Etat.PASSE);
             thisThread.sleep(tpsPasse);
              break;
           }


         }
         catch(InterruptedException e){

         }

       }
     }

     public void stop(){
       enCours=false;
     }




}
