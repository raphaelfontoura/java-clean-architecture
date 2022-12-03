package br.com.alura.dominio.aluno;

public interface EncriptarSenha {

    String cifrarSenha(String senha);

    boolean validarSenhaCifrada(String senhaCifrada, String senha);

}
