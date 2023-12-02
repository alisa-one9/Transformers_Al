package com.example.transformers_al;

public class TransformerYellow extends Transformer implements Printable {
    public int num_lasers;
    private int energy_new;

    public TransformerYellow(String name, int energy, int num_lasers) {
        super(name, energy);
        this.num_lasers = num_lasers;
    }

    public String printSelf() {
        energy_new = energy + 20000;
        return String.valueOf(energy_new);
    }
    public void shooting() {
        energy_new = energy - 200;
        String sound = "It's me - TransfomerYellow!!!";
    }
}
