public class Guerreiro extends Perssonagem {

    private double estamina;

    public Guerreiro(String name, double life, int nivel, double estamina) {
        super(name, life, nivel);
        this.estamina = estamina;
    }

    @Override
    public void atacar(Inimigo alvo) {
        double custo = 10;
        if (estamina < custo) {
            System.out.println("Estamina insuficiente!");
            return;
        }
        estamina -= custo;
        double dano = 12 + (nivel * 3);

        System.out.println(name + " golpeia " + alvo.getNome() + " com a espada!");
        alvo.receberDano(dano);
    }

    @Override
    public void curar() {
        double custo = 15;
        if (estamina < custo) {
            System.out.println("Estamina insuficiente!");
            return;
        }
        estamina -= custo;

        System.out.println(name + " respira fundo e trata os ferimentos.");
        recuperarVida(15);
    }

    @Override
    public String toString() {
        return String.format("%s (Guerreiro) - Vida: %.0f | Estamina: %.0f | Nível: %d",
                name, life, estamina, nivel);
    }
}
