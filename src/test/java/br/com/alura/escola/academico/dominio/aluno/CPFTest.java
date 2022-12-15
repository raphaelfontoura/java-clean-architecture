package br.com.alura.escola.academico.dominio.aluno;

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