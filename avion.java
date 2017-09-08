/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdel majid
 */


public class avion implements Serializable {

    private coord  position;
    private dep Deplacement;
    private String FlightName;
    private int flightId;
    private boolean isLocked;
    public boolean IsLocked() {
         return isLocked ;
    }

    public synchronized void Lock()  {
        while(isLocked)
        {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(avion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        isLocked = true ;
    }

    public synchronized void Unlock() {
        isLocked = false;
        notifyAll();
    }
    public avion(coord coordonnees, dep deplacement, String flightName) {
        position = coordonnees;
        Deplacement = deplacement;
        FlightName = flightName;
        isLocked = false;
    }

    
    public coord getPosition() {
        return position;
    }

    
    public void setPosition(coord position) {
        this.position = position;
    }

    
    public dep getDeplacement() {
        return Deplacement;
    }

  
    public void setDeplacement(dep deplacement) {
        this.Deplacement = deplacement;
    }

    public String getFlightName() {
        return FlightName;
    }

    
    public void setFlightName(String flightName) {
        this.FlightName = flightName;
    }

    public String getInfo() {
        String info = "Vol name:" + FlightName + ", " 
                + "Position: " + position.getX()+":"+position.getY()+":"+position.getAltitude()+", "
                + "Vitesse: " + Deplacement.getVitesse()+",Cap: "+Deplacement.getCap();

        return info;
    }

    public int getFlightId() {
        return flightId;
    }

    
    public void setFlightId(int _flightId) {
        this.flightId = _flightId;
    }

  
       
}
    

