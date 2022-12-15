package br.com.alura.escola.academico.dominio.aluno.exceptions;

import br.com.alura.escola.shared.dominio.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getCpf());
    }
}
