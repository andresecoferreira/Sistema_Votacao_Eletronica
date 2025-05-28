package models;

public class Administrador extends Utilizador {

    public Administrador(String id, String nome, String username, String password) {
        super(id, nome, username, password);
    }

    @Override
    public String getTipo() {
        return "ADMIN";
    }
}
