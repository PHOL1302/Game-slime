public abstract class Inimigo {

    protected String nome;
    protected double vida;
    protected double dano;
    protected int xp;

    public Inimigo(double vida, double dano, String nome, int xp) {
        this.vida = vida;
        this.dano = dano;
        this.nome = nome;
        this.xp = xp;
    }

    public String getNome() {
        return nome;
    }

    public int getXp() {
        return xp;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(double quantidade) {
        vida -= quantidade;
        if (vida < 0) {
            vida = 0;
        }
        System.out.println(nome + " recebeu " + (int) quantidade + " de dano. Vida: " + (int) vida);
    }

    public void atacar(Perssonagem alvo) {
        System.out.println(nome + " ataca " + alvo.getName() + "!");
        alvo.receberDano(dano);
    }

    @Override
    public String toString() {
        return String.format("%s - Vida: %.0f", nome, vida);
    }
}