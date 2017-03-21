/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaia_001;

/**
 *
 * @author sara
 */
public class Transition {
    public enum Action { MOVER_OVEJA, MOVER_REPOLLOS,
        MOVER_LOBO, MOVER_GRANJERO     
    }
    public State initial;
    public Action action;
    
    public State doTransition() {
        State result = new State(initial);        
        switch (action) {
            case MOVER_OVEJA:
                result.oveja = State.move(initial.oveja);
                break;
            case MOVER_REPOLLOS:
                result.repollos = State.move(initial.repollos);
                break;
            case MOVER_LOBO:
                result.lobo = State.move(initial.lobo);
                break;
        }            
        result.granjero = State.move(initial.granjero);
        return result;
    }
    
    public Transition(State state, Action action) {
        this.initial = state;
        this.action = action;
    }

    
}
