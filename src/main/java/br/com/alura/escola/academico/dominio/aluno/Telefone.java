package br.com.alura.escola.academico.dominio.aluno;

import lombok.Getter;

@Getter
public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if (ddd == null || !ddd.matches("\\d{2}$"))
            throw new IllegalArgumentException("DDD inválido.");
        if (numero == null || !numero.matches("\\d{8}$|\\d{9}$"))
            throw new IllegalArgumentException("Número do telefone inválido.");
        this.ddd = ddd;
        this.numero = numero;
    }
}
