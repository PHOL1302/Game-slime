





void main() {
    
    String Classe = IO.readln("Você deseja escolher: (Arqueiro) (Mago) (Guerreiro): ");
    
    
    if (Classe.equals("Arqueiro")) {

        double life = 100;
        int nivelPadrao = 1;
        double estaminaPadrao = 100;
        String name = IO.readln("Digite seu nick name: ");

        Perssonagem arqueiro = new Arqueiro(name, life, nivelPadrao, estaminaPadrao);

        IO.println(arqueiro);
    } else if (Classe.equals("Guerreiro")) {

        double life = 100;
        int nivelPadrao = 1;
        double estaminaPadrao = 100;
        String name = IO.readln("Digite seu nick name: ");
        Perssonagem guerreiro = new Guerreiro(name, life, nivelPadrao, estaminaPadrao);

        IO.println(guerreiro);
    } else if (Classe.equals("Mago")) {


        double life = 100;
        int nivelPadrao = 1;
        double manaPadrao = 100;
        String name = IO.readln("Digite seu nick name: ");
        Perssonagem mago = new Mago(name, life, nivelPadrao, manaPadrao);

        IO.println(mago);
    }else{
        IO.readln("Você é idiota?");
        IO.println("Não existe essa classe!!!");

    }


}