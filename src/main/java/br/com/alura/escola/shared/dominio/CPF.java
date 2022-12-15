package br.com.alura.escola.shared.dominio;

import lombok.Getter;

@Getter
public class CPF {

    private final String cpf;

    public CPF(String cpf) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return cpf;
    }
}
