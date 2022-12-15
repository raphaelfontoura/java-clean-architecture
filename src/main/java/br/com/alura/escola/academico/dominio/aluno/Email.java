package br.com.alura.escola.academico.dominio.aluno;

import lombok.Getter;

@Getter
public class Email {

    //VALUE OBJECT

    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.endereco = endereco;
    }
}
