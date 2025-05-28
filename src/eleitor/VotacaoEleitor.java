package eleitor;

import models.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VotacaoEleitor {

    private Eleitor eleitor;
    private List<Candidato> candidatos;
    private EstadoVotacao estado;
    private Scanner scanner;

    public VotacaoEleitor(Eleitor eleitor, List<Candidato> candidatos, EstadoVotacao estado) {
        this.eleitor = eleitor;
        this.candidatos = candidatos;
        this.estado = estado;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("\n=== Votação Eletrónica ===");

        if (!estado.isVotacaoIniciada()) {
            System.out.println("⚠️ A votação ainda não começou.");
            return;
        }

        if (estado.isVotacaoEncerrada()) {
            System.out.println("⚠️ A votação já foi encerrada.");
            return;
        }

        if (eleitor.isJaVotou()) {
            System.out.println("⚠️ Já efetuou o seu voto. Obrigado pela sua participação.");
            return;
        }

        if (candidatos.isEmpty()) {
            System.out.println("⚠️ Ainda não existem candidatos disponíveis.");
            return;
        }

        System.out.println("Candidatos disponíveis:");
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.println((i + 1) + ". " + candidatos.get(i).getNome());
        }

        int opcao;
        do {
            System.out.print("Digite o número do candidato em quem pretende votar: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 1 && opcao <= candidatos.size()) {
                    Candidato escolhido = candidatos.get(opcao - 1);
                    escolhido.incrementarVoto();
                    eleitor.setJaVotou(true);
                    System.out.println("✅ Voto registado com sucesso. Obrigado por participar!");
                    break;
                } else {
                    System.out.println("❌ Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida.");
            }
        } while (true);
    }
}
