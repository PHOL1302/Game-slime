public class Arqueiro extends Perssonagem {

    private double estamina;

    public Arqueiro(String name, double life, int nivel, double estamina) {
        super(name, life, nivel);
        this.estamina = estamina;
    }

    @Override
    public void atacar(Inimigo alvo) {
        double custo = 15;
        if (estamina < custo) {
            System.out.println("Estamina insuficiente!");
            return;
        }
        estamina -= custo;
        double dano = 10 + (nivel * 2);

        System.out.println(name + " dispara uma flecha em " + alvo.getNome() + "!");
        alvo.receberDano(dano);
    }

    @Override
    public void curar() {
        double custo = 20;
        if (estamina < custo) {
            System.out.println("Estamina insuficiente!");
            return;
        }
        estamina -= custo;

        System.out.println(name + " usa ervas para se curar.");
        recuperarVida(20);
    }

    @Override
    public String toString() {
        return String.format("%s (Arqueiro) - Vida: %.0f | Estamina: %.0f | Nível: %d",
                name, life, estamina, nivel);
    }
}
