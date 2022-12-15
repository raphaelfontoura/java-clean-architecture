package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;

import java.util.List;

public interface RepositorioDeSelo {

    void adicionar(Selo selo);

    List<Selo> buscarSelosPorCPF(CPF cpf);


}
