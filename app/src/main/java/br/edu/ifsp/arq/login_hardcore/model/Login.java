package br.edu.ifsp.arq.login_hardcore.model;

import br.edu.ifsp.arq.login_hardcore.constants.Constantes;

public class Login {
    private static Login sLogin = null;

    public static Login getInstance(){
        if(sLogin == null){
            sLogin = new Login();
        }
        return sLogin;
    }

    public boolean fazerLogin(int user, int senha){
        return (senha == Constantes.SENHA) && (user == Constantes.USER);
    }
}
