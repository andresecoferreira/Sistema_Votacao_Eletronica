package models;

public class Candidato {
    private String id;
    private String nome;
    private String partido;
    private int totalVotos;

    public Candidato(String id, String nome, String partido) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.totalVotos = 0;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getPartido() { return partido; }
    public int getVotos() { return totalVotos; }

    public void incrementarVoto() {
        this.totalVotos++;
    }
}
