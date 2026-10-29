public abstract class Perssonagem implements Acoes {

    protected String name;
    protected double life;
    protected double vidaMaxima;
    protected int nivel;

    public Perssonagem(String name, double life, int nivel) {
        this.name = name;
        this.life = life;
        this.vidaMaxima = life;
        this.nivel = nivel;
    }

    public String getName() {
        return name;
    }

    public double getLife() {
        return life;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean estaVivo() {
        return life > 0;
    }

    public void receberDano(double dano) {
        life -= dano;
        if (life < 0) {
            life = 0;
        }
        System.out.println(name + " recebeu " + (int) dano + " de dano. Vida: " + (int) life);
    }

    protected void recuperarVida(double quantidade) {
        life += quantidade;
        if (life > vidaMaxima) {
            life = vidaMaxima;
        }
        System.out.println(name + " recuperou vida. Vida: " + (int) life);
    }
}