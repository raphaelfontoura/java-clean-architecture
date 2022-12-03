package br.com.alura.dominio.aluno.exceptions;

import br.com.alura.dominio.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getCpf());
    }
}
