/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaia_001;

import java.util.ArrayList;

/**
 *
 * @author sara
 */
public class BreadFirstSearch {
    
    public State initial_state;
    public boolean founded_final_state = false;
    
    public BreadFirstSearch(State initial_state) {
        this.initial_state = initial_state;
    }
    
    public void doSearch() {
        int level = 1;
        System.out.println("Estado inicial: " + initial_state);
        ArrayList<State> current_states = new ArrayList<>();
        ArrayList<State> next_states = new ArrayList<>();
        ArrayList<State> visited_states = new ArrayList<>();
        
        current_states.add(initial_state);
        while (!founded_final_state) {
            System.out.println("Generando estados de nivel " + level);
            // Generamos los estados siguientes y los validamos
            for (State state: current_states) {
                for (Transition t: state.validTransitions()) {
                    State next = t.doTransition();
                    if (next.isValid() && !visited_states.contains(next)) {
                        System.out.println("- AcciÃ³n: " + t.action + 
                                ", resultado: " + next);
                        next_states.add(next);
                    }
                }
            }
            // Verificamos si llegamos a un estado final
            for (State state: next_states) {
                if (state.isFinal()) {
                    founded_final_state = true;
                    System.out.println("- Estado final: " + state);
                    break;
                }
            }
            // Marcamos los estados que ya hemos visitado
            visited_states.addAll(current_states);
            current_states.clear();
            current_states.addAll(next_states);
            next_states.clear();
            level++;
        }
    }

}
