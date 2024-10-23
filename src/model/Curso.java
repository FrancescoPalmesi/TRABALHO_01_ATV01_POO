package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String turno;
    private List<Disciplina> disciplinas;

    public Curso(String nome, String turno) {
        this.nome = nome;
        this.turno = turno;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public List<Disciplina> getDisciplinas() { return disciplinas; }
}