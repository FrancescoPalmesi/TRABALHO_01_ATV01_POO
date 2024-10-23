package dao;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public void removerAluno(String nome) {
        alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }
}