public abstract class Perssonagem {

    private String name;
    private double vida;
    private int nivel = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Perssonagem(String name, double vida, int nivel) {
        this.name = name;
        this.vida = vida;
        this.nivel = nivel;
    }


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        "\n" + "vida=" + vida +
               "\n" + "nivel=" + nivel ;
    }
}