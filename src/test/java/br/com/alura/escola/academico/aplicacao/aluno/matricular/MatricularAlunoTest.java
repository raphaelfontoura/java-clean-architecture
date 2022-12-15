package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
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