package admin;

import models.EstadoVotacao;

import java.util.Scanner;

public class GestorVotacao {

    private EstadoVotacao estado;
    private Scanner scanner;

    public GestorVotacao(EstadoVotacao estado) {
        this.estado = estado;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n=== Gestão da Votação ===");
            System.out.println("1. Iniciar votação");
            System.out.println("2. Encerrar votação");
            System.out.println("3. Ver estado da votação");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> estado.iniciarVotacao();
                case 2 -> estado.encerrarVotacao();
                case 3 -> estado.mostrarEstado();
                case 0 -> System.out.println("A voltar ao menu anterior...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
