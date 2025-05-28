import auth.LoginService;
import models.Utilizador;
import models.Administrador;
import models.Eleitor;
import admin.GestorCandidatos;
import admin.GestorEleitores;
import admin.GestorVotacao;
import admin.ApuradorResultados;
import eleitor.VotacaoEleitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        System.out.println("=== SISTEMA DE VOTAÇÃO ELETRÓNICA ===");

        Utilizador utilizador = null;
        while (utilizador == null) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            utilizador = loginService.login(username, password);
            if (utilizador == null) {
                System.out.println("Credenciais inválidas. Tente novamente.\n");
            }
        }

        if (utilizador instanceof Administrador) {
            Administrador admin = (Administrador) utilizador;
            int opcao;
            do {
                System.out.println("\n--- Menu Administrador ---");
                System.out.println("1. Gerir Candidatos");
                System.out.println("2. Gerir Eleitores");
                System.out.println("3. Iniciar Votação");
                System.out.println("4. Encerrar Votação");
                System.out.println("5. Ver Resultados");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        GestorCandidatos.menu(scanner);
                        break;
                    case 2:
                        GestorEleitores.menu(scanner);
                        break;
                    case 3:
                        GestorVotacao.iniciarVotacao();
                        break;
                    case 4:
                        GestorVotacao.encerrarVotacao();
                        break;
                    case 5:
                        ApuradorResultados.exibirResultados();
                        break;
                }
            } while (opcao != 0);

        } else if (utilizador instanceof Eleitor) {
            Eleitor eleitor = (Eleitor) utilizador;
            if (eleitor.jaVotou()) {
                System.out.println("Você já votou. Não é possível votar novamente.");
            } else {
                VotacaoEleitor.realizarVoto(eleitor, scanner);
            }
        }

        System.out.println("Sessão encerrada. Obrigado por utilizar o sistema.");
        scanner.close();
    }
}
