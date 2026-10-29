import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class JogoTela extends JFrame {

    private final CardLayout cartas = new CardLayout();
    private final JPanel raiz = new JPanel(cartas);

    private final JTextArea log = new JTextArea();
    private final JLabel status = new JLabel(" ");

    private final JButton botaoAtacar = new JButton("Atacar");
    private final JButton botaoCurar = new JButton("Curar");

    private Perssonagem jogador;
    private Inimigo inimigo;

    public JogoTela() {
        super("Meu RPG");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        raiz.add(criarTelaEscolha(), "escolha");
        raiz.add(criarTelaBatalha(), "batalha");
        add(raiz);

        redirecionarSaida();
    }

    // ---------- TELA 1: escolha da classe ----------
    private JPanel criarTelaEscolha() {
        JPanel painel = new JPanel(new GridLayout(0, 1, 8, 8));
        painel.setBorder(BorderFactory.createEmptyBorder(40, 120, 40, 120));

        JComboBox<String> comboClasse =
                new JComboBox<>(new String[]{"Arqueiro", "Guerreiro", "Mago"});
        JTextField campoNome = new JTextField();
        JButton botao = new JButton("Começar aventura");

        painel.add(new JLabel("Escolha sua classe:", SwingConstants.CENTER));
        painel.add(comboClasse);
        painel.add(new JLabel("Nick name:", SwingConstants.CENTER));
        painel.add(campoNome);
        painel.add(botao);

        botao.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite um nick name!");
                return;
            }

            switch ((String) comboClasse.getSelectedItem()) {
                case "Arqueiro" -> jogador = new Arqueiro(nome, 100, 1, 100);
                case "Guerreiro" -> jogador = new Guerreiro(nome, 100, 1, 100);
                case "Mago" -> jogador = new Mago(nome, 100, 1, 20, 100);
            }
            inimigo = new Slime(50, 20, "Slime", 30);

            log.setText("Um Slime apareceu!\n");
            botaoAtacar.setEnabled(true);
            botaoCurar.setEnabled(true);
            atualizarStatus();
            cartas.show(raiz, "batalha");
        });

        return painel;
    }

    // ---------- TELA 2: batalha ----------
    private JPanel criarTelaBatalha() {
        JPanel painel = new JPanel(new BorderLayout(8, 8));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        log.setEditable(false);
        log.setLineWrap(true);

        JButton voltar = new JButton("Voltar");

        botaoAtacar.addActionListener(e -> {
            jogador.atacar(inimigo);
            fimDoTurno();
        });

        botaoCurar.addActionListener(e -> {
            jogador.curar();
            fimDoTurno();
        });

        voltar.addActionListener(e -> cartas.show(raiz, "escolha"));

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        botoes.add(botaoAtacar);
        botoes.add(botaoCurar);
        botoes.add(voltar);

        painel.add(status, BorderLayout.NORTH);
        painel.add(new JScrollPane(log), BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);
        return painel;
    }

    // Depois da ação do jogador: confere se o inimigo morreu, senão ele contra-ataca
    private void fimDoTurno() {
        if (!inimigo.estaVivo()) {
            System.out.println("Você derrotou o " + inimigo.getNome()
                    + "! +" + inimigo.getXp() + " de XP");
            travarAcoes();
        } else {
            inimigo.atacar(jogador);
            if (!jogador.estaVivo()) {
                System.out.println("Você foi derrotado...");
                travarAcoes();
            }
        }
        atualizarStatus();
    }

    private void travarAcoes() {
        botaoAtacar.setEnabled(false);
        botaoCurar.setEnabled(false);
    }

    private void atualizarStatus() {
        status.setText("<html>Você: " + jogador + "<br>Inimigo: " + inimigo + "</html>");
    }

    // Faz os System.out.println das suas classes aparecerem dentro da janela
    private void redirecionarSaida() {
        OutputStream saida = new OutputStream() {
            @Override
            public void write(int b) {
                write(new byte[]{(byte) b}, 0, 1);
            }

            @Override
            public void write(byte[] b, int off, int len) {
                String texto = new String(b, off, len, StandardCharsets.UTF_8);
                SwingUtilities.invokeLater(() -> {
                    log.append(texto);
                    log.setCaretPosition(log.getDocument().getLength());
                });
            }
        };
        System.setOut(new PrintStream(saida, true, StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JogoTela().setVisible(true));
    }
}