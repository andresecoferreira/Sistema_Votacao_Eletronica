package admin;

import models.Eleitor;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestorEleitores {

    private List<Eleitor> eleitores;
    private Scanner scanner;

    public GestorEleitores(List<Eleitor> eleitores) {
        this.eleitores = eleitores;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n=== Gestão de Eleitores ===");
            System.out.println("1. Inserir eleitor");
            System.out.println("2. Editar eleitor");
            System.out.println("3. Remover eleitor");
            System.out.println("4. Listar eleitores");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> inserirEleitor();
                case 2 -> editarEleitor();
                case 3 -> removerEleitor();
                case 4 -> listarEleitores();
                case 0 -> System.out.println("A voltar ao menu anterior...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void inserirEleitor() {
        System.out.print("ID do eleitor: ");
        String id = scanner.nextLine();
        System.out.print("Nome do eleitor: ");
        String nome = scanner.nextLine();
        System.out.print("Username do eleitor: ");
        String username = scanner.nextLine();
        System.out.print("Password do eleitor: ");
        String password = scanner.nextLine();

        Eleitor novo = new Eleitor(id, nome, username, password);
        eleitores.add(novo);

        System.out.println("Eleitor inserido com sucesso.");
    }

    private void editarEleitor() {
        System.out.print("ID do eleitor a editar: ");
        String id = scanner.nextLine();

        Optional<Eleitor> eleitorOpt = eleitores.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (eleitorOpt.isPresent()) {
            Eleitor e = eleitorOpt.get();

            System.out.print("Novo nome (" + e.getNome() + "): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) e = new Eleitor(e.getId(), nome, e.getUsername(), e.getPassword());

            System.out.print("Novo username (" + e.getUsername() + "): ");
            String username = scanner.nextLine();
            if (!username.isEmpty()) e = new Eleitor(e.getId(), e.getNome(), username, e.getPassword());

            System.out.print("Nova password: ");
            String password = scanner.nextLine();
            if (!password.isEmpty()) e = new Eleitor(e.getId(), e.getNome(), e.getUsername(), password);

            e.setJaVotou(false); // Reset do voto se foi recriado

            eleitores.removeIf(x -> x.getId().equals(id));
            eleitores.add(e);

            System.out.println("Eleitor editado com sucesso.");
        } else {
            System.out.println("Eleitor não encontrado.");
        }
    }

    private void removerEleitor() {
        System.out.print("ID do eleitor a remover: ");
        String id = scanner.nextLine();

        boolean removido = eleitores.removeIf(e -> e.getId().equals(id));
        if (removido) {
            System.out.println("Eleitor removido com sucesso.");
        } else {
            System.out.println("Eleitor não encontrado.");
        }
    }

    private void listarEleitores() {
        System.out.println("\nLista de Eleitores:");
        if (eleitores.isEmpty()) {
            System.out.println("(nenhum eleitor registado)");
        } else {
            for (Eleitor e : eleitores) {
                System.out.println("- " + e.getId() + " | " + e.getNome() + " | Votou? " + (e.isJaVotou() ? "Sim" : "Não"));
            }
        }
    }
}
