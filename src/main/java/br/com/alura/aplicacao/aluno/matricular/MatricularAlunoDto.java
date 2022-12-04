package br.com.alura.aplicacao.aluno.matricular;

import br.com.alura.dominio.aluno.Aluno;
import br.com.alura.dominio.aluno.FabricaDeAluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MatricularAlunoDto {

    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public Aluno criarAluno() {
        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        Aluno aluno = fabricaDeAluno.comNomeCPFEmail(nomeAluno, cpfAluno, emailAluno)
                .criar();
        return aluno;
    }
}
