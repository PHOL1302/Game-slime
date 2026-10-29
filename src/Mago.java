public class Mago extends Perssonagem {

    private double poderMagico;
    private double mana;

    public Mago(String name, double life, int nivel, double poderMagico, double mana) {
        super(name, life, nivel);
        this.poderMagico = poderMagico;
        this.mana = mana;
    }

    @Override
    public void atacar(Inimigo alvo) {
        double custo = 25;
        if (mana < custo) {
            System.out.println("Mana insuficiente!");
            return;
        }
        mana -= custo;
        double dano = poderMagico + (nivel * 3);

        System.out.println(name + " lança uma bola de fogo em " + alvo.getNome() + "!");
        alvo.receberDano(dano);
    }

    @Override
    public void curar() {
        double custo = 20;
        if (mana < custo) {
            System.out.println("Mana insuficiente!");
            return;
        }
        mana -= custo;

        System.out.println(name + " usa magia de cura.");
        recuperarVida(25);
    }

    @Override
    public String toString() {
        return String.format("%s (Mago) - Vida: %.0f | Mana: %.0f | Nível: %d",
                name, life, mana, nivel);
    }
}