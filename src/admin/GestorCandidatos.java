package admin;

import models.Candidato;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestorCandidatos {

    private List<Candidato> candidatos;
    private Scanner scanner;

    public GestorCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n=== Gestão de Candidatos ===");
            System.out.println("1. Inserir candidato");
            System.out.println("2. Editar candidato");
            System.out.println("3. Remover candidato");
            System.out.println("4. Listar candidatos");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> inserirCandidato();
                case 2 -> editarCandidato();
                case 3 -> removerCandidato();
                case 4 -> listarCandidatos();
                case 0 -> System.out.println("A voltar ao menu anterior...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void inserirCandidato() {
        System.out.print("ID do candidato: ");
        String id = scanner.nextLine();
        System.out.print("Nome do candidato: ");
        String nome = scanner.nextLine();
        System.out.print("Partido do candidato: ");
        String partido = scanner.nextLine();

        Candidato novo = new Candidato(id, nome, partido);
        candidatos.add(novo);

        System.out.println("Candidato inserido com sucesso.");
    }

    private void editarCandidato() {
        System.out.print("ID do candidato a editar: ");
        String id = scanner.nextLine();

        Optional<Candidato> candidatoOpt = candidatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (candidatoOpt.isPresent()) {
            Candidato c = candidatoOpt.get();

            System.out.print("Novo nome (" + c.getNome() + "): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) c = new Candidato(c.getId(), nome, c.getPartido());

            System.out.print("Novo partido (" + c.getPartido() + "): ");
            String partido = scanner.nextLine();
            if (!partido.isEmpty()) c = new Candidato(c.getId(), c.getNome(), partido);

            // Substituir o candidato na lista
            candidatos.removeIf(x -> x.getId().equals(id));
            candidatos.add(c);

            System.out.println("Candidato editado com sucesso.");
        } else {
            System.out.println("Candidato não encontrado.");
        }
    }

    private void removerCandidato() {
        System.out.print("ID do candidato a remover: ");
        String id = scanner.nextLine();

        boolean removido = candidatos.removeIf(c -> c.getId().equals(id));
        if (removido) {
            System.out.println("Candidato removido com sucesso.");
        } else {
            System.out.println("Candidato não encontrado.");
        }
    }

    private void listarCandidatos() {
        System.out.println("\nLista de Candidatos:");
        if (candidatos.isEmpty()) {
            System.out.println("(nenhum candidato registado)");
        } else {
            for (Candidato c : candidatos) {
                System.out.println("- " + c.getId() + " | " + c.getNome() + " | " + c.getPartido());
            }
        }
    }
}
