package br.com.alura.infra.aluno;

import br.com.alura.dominio.aluno.*;
import br.com.alura.dominio.aluno.exceptions.AlunoNaoEncontrado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAluno {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO Aluno VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO Telefones VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        try {
            String sql = "SELECT id, nome, email FROM Aluno WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }
            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno aluno = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM Telefone WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                aluno.adicionarTelefone(ddd, numero);
            }

            return aluno;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosOsAlunosMatriculados() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM Aluno";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();

            while (resultSet.next()) {
                CPF cpf = new CPF(resultSet.getString("cpf"));
                String nome = resultSet.getString("nome");
                Email email = new Email(resultSet.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = resultSet.getLong("id");
                sql = "SELECT ddd, numero FROM Telefone WHERE aluno_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    String numero = resultSet.getString("numero");
                    String ddd = resultSet.getString("ddd");
                    aluno.adicionarTelefone(ddd, numero);
                }
                alunos.add(aluno);
            }
            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
