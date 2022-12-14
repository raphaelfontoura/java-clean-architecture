package br.com.alura.dominio.aluno;

import br.com.alura.dominio.Evento;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AlunoMatriculado implements Evento {

    private final CPF cpfDoAluno;
    private final LocalDateTime momento = LocalDateTime.now();

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }
}
