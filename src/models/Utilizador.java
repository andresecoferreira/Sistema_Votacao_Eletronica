package models;

public abstract class Utilizador {
    protected String id;
    protected String nome;
    protected String username;
    protected String password;

    public Utilizador(String id, String nome, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public abstract String getTipo(); // "ADMIN" ou "ELEITOR"
}
