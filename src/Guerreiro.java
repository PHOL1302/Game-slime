import java.lang.classfile.Superclass;

public class Guerreiro extends Perssonagem {
    private double estamina = 100;



    public double getEstamina() {
        return estamina;
    }

    public void setEstamina(double estamina) {
        this.estamina = estamina;
    }


    public Guerreiro(String name, double vida, int nivel, double estamina) {
        super(name, vida, nivel);
        this.estamina = estamina;
    }

    @Override
    public String toString() {
        return  "Guerreiro" + super.toString() +
                "estamina=" + estamina ;
    }
}
