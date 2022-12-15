package br.com.alura.escola.gamificacao.infra.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelo;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.dominio.selo.exceptions.SeloNaoEcontrado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSeloEmMemoria implements RepositorioDeSelo {

    private final List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        selos.add(selo);
    }

    @Override
    public List<Selo> buscarSelosPorCPF(CPF cpf) {
        List<Selo> seloList = selos.stream().filter(selo -> selo.getCpfDoAluno().equals(cpf)).collect(Collectors.toList());
        if (seloList.isEmpty())
            throw new SeloNaoEcontrado(cpf);
        return seloList;
    }
}
