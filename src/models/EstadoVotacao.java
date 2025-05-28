package models;

public class EstadoVotacao {
    private boolean votacaoIniciada;
    private boolean votacaoEncerrada;

    public EstadoVotacao() {
        this.votacaoIniciada = false;
        this.votacaoEncerrada = false;
    }

    public boolean isVotacaoIniciada() {
        return votacaoIniciada;
    }

    public boolean isVotacaoEncerrada() {
        return votacaoEncerrada;
    }

    public void iniciarVotacao() {
        if (!votacaoIniciada) {
            votacaoIniciada = true;
            System.out.println("✅ Votação iniciada com sucesso.");
        } else {
            System.out.println("⚠️ A votação já foi iniciada.");
        }
    }

    public void encerrarVotacao() {
        if (votacaoIniciada && !votacaoEncerrada) {
            votacaoEncerrada = true;
            System.out.println("✅ Votação encerrada com sucesso.");
        } else if (!votacaoIniciada) {
            System.out.println("⚠️ A votação ainda não foi iniciada.");
        } else {
            System.out.println("⚠️ A votação já foi encerrada.");
        }
    }

    public void mostrarEstado() {
        if (!votacaoIniciada) {
            System.out.println("🕒 Estado: A votação ainda não começou.");
        } else if (!votacaoEncerrada) {
            System.out.println("🟢 Estado: Votação em curso.");
        } else {
            System.out.println("🔴 Estado: Votação encerrada.");
        }
    }
}
