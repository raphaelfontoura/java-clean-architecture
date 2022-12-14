package br.com.alura.aplicacao.aluno.matricular;

import br.com.alura.dominio.PublicadorDeEventos;
import br.com.alura.dominio.aluno.Aluno;
import br.com.alura.dominio.aluno.CPF;
import br.com.alura.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    void executa_deveriaPersistirUmAluno() {
        // Poderia usar um MOCK
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "111.222.333-44", "fulano@email.com");

        MatricularAluno useCase = new MatricularAluno(repositorio, new PublicadorDeEventos());

        useCase.executa(dados);

        Aluno alunoEncontrado = repositorio.buscarPorCpf(new CPF("111.222.333-44"));
        assertEquals("Fulano", alunoEncontrado.getNome());
        assertEquals("fulano@email.com", alunoEncontrado.getEmail());
    }
}