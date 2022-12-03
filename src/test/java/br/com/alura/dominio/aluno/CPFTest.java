package br.com.alura.dominio.aluno;

import br.com.alura.dominio.aluno.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void naoDeveriaCriarCPFQuandoDadosForemInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234"));
    }

    @Test
    void deveriaCriaCPFQuandoDadosForemValidos() {
        assertDoesNotThrow(() -> new CPF("111.222.333-45"));
    }
}