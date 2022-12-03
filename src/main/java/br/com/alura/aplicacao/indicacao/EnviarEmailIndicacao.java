package br.com.alura.aplicacao.indicacao;

import br.com.alura.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno aluno);
}
