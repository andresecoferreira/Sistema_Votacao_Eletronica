package auth;

import models.Utilizador;

import java.util.Scanner;

public class LoginService {

    private Autenticador autenticador;

    public LoginService(Autenticador autenticador) {
        this.autenticador = autenticador;
    }

    public Utilizador fazerLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Utilizador u = autenticador.autenticar(username, password);

        if (u == null) {
            System.out.println("Credenciais inválidas!");
        } else {
            System.out.println("Bem-vindo, " + u.getNome() + " (" + u.getTipo() + ")");
        }

        return u;
    }
}
