public class Arqueiro extends Perssonagem {

    private double estamina = 100;



    public double getEstamina() {
        return estamina;
    }

    public void setEstamina(double estamina) {
        this.estamina = estamina;
    }

    public Arqueiro(String name, double vida, int nivel, double estamina) {
        super(name, vida, nivel);
        this.estamina = estamina;
    }


    @Override
    public String toString() {
        return "Classe: "+ "Arqueiro"+ "\n" + super.toString() +
               "\n" + "estamina=" + estamina ;
    }






}
