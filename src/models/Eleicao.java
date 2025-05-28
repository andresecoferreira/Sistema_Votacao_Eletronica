package models;

import java.util.*;

public class Eleicao {
    private boolean ativa;
    private Date dataInicio;
    private Date dataFim;
    private List<Candidato> candidatos;
    private List<Eleitor> eleitores;
    private List<Voto> votos;

    public Eleicao() {
        this.ativa = false;
        this.candidatos = new ArrayList<>();
        this.eleitores = new ArrayList<>();
        this.votos = new ArrayList<>();
    }

    public boolean isAtiva() { return ativa; }
    public void iniciar() {
        this.ativa = true;
        this.dataInicio = new Date();
    }

    public void encerrar() {
        this.ativa = false;
        this.dataFim = new Date();
    }

    public List<Candidato> getCandidatos() { return candidatos; }
    public List<Eleitor> getEleitores() { return eleitores; }
    public List<Voto> getVotos() { return votos; }

    public void adicionarCandidato(Candidato c) {
        candidatos.add(c);
    }

    public void adicionarEleitor(Eleitor e) {
        eleitores.add(e);
    }

    public void registarVoto(Voto v) {
        votos.add(v);
    }

    public Optional<Candidato> getCandidatoPorId(String id) {
        return candidatos.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Optional<Eleitor> getEleitorPorId(String id) {
        return eleitores.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
}
