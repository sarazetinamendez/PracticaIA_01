/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaia_001;

import java.util.ArrayList;
import practicaia_001.Transition.Action;

/**
 *
 * @author sara
 */
public class State {
    
    public enum Position { DERECHA, IZQUIERDA }
    public Position oveja;
    public Position repollos;
    public Position lobo;
    public Position granjero;
    
    public State() {}
    public State(State aState) {
        this.oveja = aState.oveja;
        this.repollos = aState.repollos;
        this.lobo = aState.lobo;
        this.granjero = aState.granjero;
    }
    
    public static Position move(Position p) {
        return (p == Position.DERECHA ? Position.IZQUIERDA : Position.DERECHA);
    }
    
    public boolean isValid() {
        return ( !((oveja == repollos) && (granjero != oveja)) &&
                 !((oveja == lobo) && (granjero != oveja)) );        
    }
    
    public boolean isFinal() {
        return ((oveja == repollos) &&
                (repollos == lobo) &&
                (lobo == granjero) &&
                (granjero == Position.IZQUIERDA));
    }
    
    public ArrayList<Transition> validTransitions() {
        ArrayList<Transition> result = new ArrayList<>();
        result.add(new Transition(this, Action.MOVER_GRANJERO));
        if (oveja == granjero) result.add(new Transition(this, Action.MOVER_OVEJA));
        if (repollos == granjero) result.add(new Transition(this, Action.MOVER_REPOLLOS));
        if (lobo == granjero) result.add(new Transition(this, Action.MOVER_LOBO));
        return result;
    }

    @Override
    public String toString() {
        return "PosiciÃ³n oveja: " + oveja + ", " +
                "PosiciÃ³n repollos: " + repollos + ", " +
                "PosiciÃ³n lobo: " + lobo + ", " +
                "PosiciÃ³n granjero: " + granjero + ".";
    }

    @Override
    public boolean equals(Object obj) {
        State s = (State)obj;
        return ( (oveja == s.oveja) && (repollos == s.repollos) && (lobo == s.lobo) && (granjero == s.granjero) );
    }    

    
}
