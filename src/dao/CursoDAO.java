package dao;

import model.Curso;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private List<Curso> cursos = new ArrayList<>();

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public Curso buscarCurso(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
            }
        }
        return null;
    }

    public void removerCurso(String nome) {
        cursos.removeIf(curso -> curso.getNome().equalsIgnoreCase(nome));
    }

    public List<Curso> listarCursos() {
        return cursos;
    }
}