package Ch_12_Practice;

import java.util.ArrayList;

public class domino_set {
    ArrayList<domino> dominos;

    public domino_set(ArrayList<domino> dominos){
        this.dominos = dominos;
    }

    public void has_chain(int start, int end){
        ArrayList<domino> chain = new ArrayList<>();
        for(domino choice: dominos){
            ArrayList<domino> new_chain = (ArrayList<domino>) chain.clone();
            new_chain.add(choice);
            ArrayList<domino> new_choices = (ArrayList<domino>) dominos.clone();
            new_choices.remove(choice);
            has_chain(start, end, new_chain, new_choices);
        }
    }

    private void has_chain(int start, int end, ArrayList<domino> chain, ArrayList<domino> choices){

        int last_domino_end = chain.get(chain.size()-1).end();

        //If this chain satisfies the conditions
        if(chain.get(0).start == start && last_domino_end == end){
            for(domino d : chain)
                System.out.print(d.toString());
            System.out.println();
        }

        for(domino choice: choices) {
            if (last_domino_end == choice.start) {
                ArrayList<domino> new_chain = (ArrayList<domino>) chain.clone();
                new_chain.add(choice);
                ArrayList<domino> new_choices = (ArrayList<domino>) choices.clone();
                new_choices.remove(choice);
                has_chain(start, end, new_chain, new_choices);
            }
        }
    }
}
