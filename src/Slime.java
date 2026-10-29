public class Slime extends Inimigo {

    public Slime(double vida, double dano, String nome, int xp) {
        super(vida, dano, nome, xp);
    }

    @Override
    public void atacar(Perssonagem alvo) {
        System.out.println(nome + " pula e esmaga " + alvo.getName() + "!");
        alvo.receberDano(dano);
    }
}






