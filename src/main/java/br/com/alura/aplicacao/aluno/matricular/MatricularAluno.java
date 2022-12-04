package br.com.alura.aplicacao.aluno.matricular;

import br.com.alura.dominio.aluno.Aluno;
import br.com.alura.dominio.aluno.RepositorioDeAluno;

public class MatricularAluno {

    private final RepositorioDeAluno repositorio;

    public MatricularAluno(RepositorioDeAluno repositorio) {
        this.repositorio = repositorio;
    }

    // COMMAND pattern
    public void executa(MatricularAlunoDto dto) {
        Aluno aluno = dto.criarAluno();
        repositorio.matricular(aluno);
    }
}
