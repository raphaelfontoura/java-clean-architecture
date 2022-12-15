package br.com.alura.escola.academico.dominio.aluno;

import java.util.List;

public interface RepositorioDeAluno {

    void matricular(Aluno aluno);

    Aluno buscarPorCpf(CPF cpf);

    List<Aluno> listarTodosOsAlunosMatriculados();

}
