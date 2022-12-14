package br.com.alura.infra.aluno;

import br.com.alura.dominio.aluno.Aluno;
import br.com.alura.dominio.aluno.CPF;
import br.com.alura.dominio.aluno.RepositorioDeAluno;
import br.com.alura.dominio.aluno.exceptions.AlunoNaoEncontrado;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAluno {

    List<Aluno> alunosMatriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.alunosMatriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        return alunosMatriculados.stream()
                .filter(a -> a.getCpf().toString().equals(cpf.getCpf()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosOsAlunosMatriculados() {
        return this.alunosMatriculados;
    }
}
