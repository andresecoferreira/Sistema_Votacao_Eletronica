package auth;

import models.*;

import java.util.List;

public class Autenticador {

    private List<Utilizador> utilizadores;

    public Autenticador(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public Utilizador autenticar(String username, String password) {
        for (Utilizador u : utilizadores) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
