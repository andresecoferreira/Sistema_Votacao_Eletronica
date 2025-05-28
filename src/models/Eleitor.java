package models;

public class Eleitor extends Utilizador {
    private boolean jaVotou;

    public Eleitor(String id, String nome, String username, String password) {
        super(id, nome, username, password);
        this.jaVotou = false;
    }

    public boolean isJaVotou() {
        return jaVotou;
    }

    public void setJaVotou(boolean jaVotou) {
        this.jaVotou = jaVotou;
    }

    @Override
    public String getTipo() {
        return "ELEITOR";
    }
}
