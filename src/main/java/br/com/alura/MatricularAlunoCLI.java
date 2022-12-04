package br.com.alura;

import br.com.alura.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoCLI {

    public static void main(String[] args) {
        String nome = "Fulano";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricularAluno.executa(new MatricularAlunoDto(nome, cpf, email));

    }
}
