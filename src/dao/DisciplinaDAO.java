package dao;

import model.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public Disciplina buscarDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    public void removerDisciplina(String nome) {
        disciplinas.removeIf(disciplina -> disciplina.getNome().equalsIgnoreCase(nome));
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinas;
    }
}