package br.com.alura.escola.gamificacao.dominio.selo.exceptions;

import br.com.alura.escola.shared.dominio.CPF;

public class SeloNaoEcontrado extends RuntimeException{
    public SeloNaoEcontrado(CPF cpf) {
        super("Não foi encontrado nenhum selo para o cpf " + cpf.toString());
    }
}
