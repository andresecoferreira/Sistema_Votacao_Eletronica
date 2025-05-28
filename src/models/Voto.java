package models;

public class Voto {
    private String idEleitor;
    private String idCandidato;

    public Voto(String idEleitor, String idCandidato) {
        this.idEleitor = idEleitor;
        this.idCandidato = idCandidato;
    }

    public String getIdEleitor() { return idEleitor; }
    public String getIdCandidato() { return idCandidato; }
}
