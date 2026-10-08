public class Mago extends Perssonagem {

    private double mana;


    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public Mago(String name, double vida, int nivel, double mana) {
        super(name, vida, nivel);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Classe: "+"Mago" + "\n" + super.toString() +"\n"+
                "mana=" + mana ;
    }
}
