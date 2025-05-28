package admin;

import models.Candidato;
import models.EstadoVotacao;

import java.util.Comparator;
import java.util.List;

public class ApuradorResultados {

    private List<Candidato> candidatos;
    private EstadoVotacao estado;

    public ApuradorResultados(List<Candidato> candidatos, EstadoVotacao estado) {
        this.candidatos = candidatos;
        this.estado = estado;
    }

    public void mostrarResultados() {
        System.out.println("\n=== Resultados da Votação ===");

        if (!estado.isVotacaoEncerrada()) {
            System.out.println("⚠️ A votação ainda não foi encerrada.");
            return;
        }

        if (candidatos.isEmpty()) {
            System.out.println("⚠️ Nenhum candidato disponível.");
            return;
        }

        int totalVotos = candidatos.stream().mapToInt(Candidato::getVotos).sum();

        if (totalVotos == 0) {
            System.out.println("⚠️ Nenhum voto foi registado.");
            return;
        }

        System.out.printf("Total de votos: %d\n", totalVotos);
        System.out.println("\nCandidatos:");

        candidatos.forEach(c -> {
            double percentagem = (c.getVotos() * 100.0) / totalVotos;
            System.out.printf("- %s: %d votos (%.2f%%)\n", c.getNome(), c.getVotos(), percentagem);
        });

        // Determinar vencedor ou empate
        int maxVotos = candidatos.stream().mapToInt(Candidato::getVotos).max().orElse(0);

        List<Candidato> vencedores = candidatos.stream()
                .filter(c -> c.getVotos() == maxVotos)
                .toList();

        if (vencedores.size() == 1) {
            System.out.println("\n🏆 Vencedor: " + vencedores.get(0).getNome());
        } else {
            System.out.println("\n🤝 Empate entre:");
            vencedores.forEach(c -> System.out.println("- " + c.getNome()));
        }
    }
}
