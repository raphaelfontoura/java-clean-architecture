package br.com.alura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void naoDeveriaCriarTelefoneComDDDouNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "2"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "1234567"));
    }

    @Test
    void deveriaCriarTelefoneQuandoDDDeNumeroSaoValidos() {
        assertDoesNotThrow(() -> new Telefone("12","12345678"));
        assertDoesNotThrow(() -> new Telefone("12","123456789"));
    }
}