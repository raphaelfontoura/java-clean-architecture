package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        this.aluno = new Aluno(
                new CPF("123.456.789-11"),
                "Fulano Teste",
                new Email("fulano@email.com")
        );
    }

    @Test
    void adicionarTelefone() {
        aluno.adicionarTelefone("61","22223344");
        aluno.adicionarTelefone("61","999923344");
        assertEquals(2, aluno.getTelefones().size());
    }

    @Test
    void adicionaTelefone_deveriaRetornarExcecaoAoAdicionarMaisQue2Telefones() {
        aluno.adicionarTelefone("61","22223344");
        aluno.adicionarTelefone("61","999923344");
        assertThrows(IllegalArgumentException.class, () -> aluno.adicionarTelefone("11","33334455"));
    }
}