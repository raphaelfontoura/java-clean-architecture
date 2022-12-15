package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeSelo {

    void adicionar(Selo selo);

    List<Selo> buscarSelosPorCPF(CPF cpf);


}
