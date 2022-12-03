package br.com.alura.dominio.indicacao;

import br.com.alura.dominio.aluno.Aluno;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Indicacao {

    private Aluno indicado;
    private Aluno indicante;

    private LocalDateTime dataIndicacao;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
        this.dataIndicacao = LocalDateTime.now();
    }
}
