package br.com.alura.dominio.aluno;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Aluno {

    //ENTIDADE

    private CPF cpf;
    private String nome;
    private Email email;

    private String senha;

    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) { // Invariante
        if (telefones.size() == 2) {
            throw new IllegalArgumentException("Permitido apenas 2 números de telefone por aluno.");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return this.cpf.getCpf();
    }

    public String getEmail() {
        return this.email.getEndereco();
    }

}
