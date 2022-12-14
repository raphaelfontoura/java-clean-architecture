package br.com.alura.dominio.aluno;

import br.com.alura.dominio.Evento;
import br.com.alura.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAo(Evento evento) {
        String momentoString = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.printf(
                "Aluno com CPF %s matriculado em: %s%n",
                ((AlunoMatriculado) evento).getCpfDoAluno().toString(),
                momentoString);
    }


    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
