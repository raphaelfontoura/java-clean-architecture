package br.com.alura.aplicacao.aluno.matricular;

import br.com.alura.dominio.PublicadorDeEventos;
import br.com.alura.dominio.aluno.Aluno;
import br.com.alura.dominio.aluno.AlunoMatriculado;
import br.com.alura.dominio.aluno.RepositorioDeAluno;

public class MatricularAluno {

    private final RepositorioDeAluno repositorio;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAluno repositorio, PublicadorDeEventos publicador) {
        this.publicador = publicador;
        this.repositorio = repositorio;
    }

    // COMMAND pattern
    public void executa(MatricularAlunoDto dto) {
        Aluno aluno = dto.criarAluno();
        repositorio.matricular(aluno);
        AlunoMatriculado evento = new AlunoMatriculado(aluno.getCpf());
        publicador.publicar(evento);
    }
}
