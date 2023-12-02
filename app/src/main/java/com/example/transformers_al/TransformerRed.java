package com.example.transformers_al;

public class TransformerRed extends Transformer implements Printable{
    public  int num_lasers;
    public String opisanie;

    public TransformerRed(String name, int energy, int num_lasers) {
        super(name, energy);
        this.num_lasers = num_lasers;
    }
    public int getNum_lasers() {
        return num_lasers;
    }

    public void setNum_lasers(int num_lasers) {
        this.num_lasers = num_lasers;
    }


    public String printSelf() {
        opisanie = String.valueOf(getName()+"-"+getNum_lasers()*400);
        return opisanie;
    }
    public void shooting() {
        energy = energy +2000;
    }
}
