package controller;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import model.Aluno;
import model.Curso;
import model.Disciplina;

import java.util.Scanner;

public class SistemaGestaoController {
    private AlunoDAO alunoDAO = new AlunoDAO();
    private CursoDAO cursoDAO = new CursoDAO();
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        while (true) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1-Gerenciar ALUNOS");
            System.out.println("2-Gerenciar DISCIPLINAS");
            System.out.println("3-Gerenciar CURSOS");
            System.out.println("4-SAIR");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            switch (opcao) {
                case 1 -> menuAlunos();
                case 2 -> menuDisciplinas();
                case 3 -> menuCursos();
                case 4 -> System.exit(0);
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void menuAlunos() {
        while (true) {
            System.out.println("MENU ALUNOS");
            System.out.println("1-Cadastrar ALUNO");
            System.out.println("2-Consultar ALUNO");
            System.out.println("3-Remover ALUNO");
            System.out.println("4-Atualizar ALUNO");
            System.out.println("5-Voltar ao MENU INICIAL");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> consultarAluno();
                case 3 -> removerAluno();
                case 4 -> atualizarAluno();
                case 5 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void menuDisciplinas() {
        while (true) {
            System.out.println("MENU DISCIPLINAS");
            System.out.println("1-Cadastrar DISCIPLINA");
            System.out.println("2-Consultar DISCIPLINA");
            System.out.println("3-Remover DISCIPLINA");
            System.out.println("4-Atualizar DISCIPLINA");
            System.out.println("5-Voltar ao MENU INICIAL");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> cadastrarDisciplina();
                case 2 -> consultarDisciplina();
                case 3 -> removerDisciplina();
                case 4 -> atualizarDisciplina();
                case 5 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void menuCursos() {
        while (true) {
            System.out.println("MENU CURSOS");
            System.out.println("1-Cadastrar CURSO");
            System.out.println("2-Consultar CURSO");
            System.out.println("3-Remover CURSO");
            System.out.println("4-Atualizar CURSO");
            System.out.println("5-Voltar ao MENU INICIAL");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> cadastrarCurso();
                case 2 -> consultarCurso();
                case 3 -> removerCurso();
                case 4 -> atualizarCurso();
                case 5 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // Métodos para gerenciar alunos
    private void cadastrarAluno() {
        System.out.println("Nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Idade do aluno:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escolha um curso pelo índice:");
        listarCursos();
        int cursoIndex = scanner.nextInt();
        scanner.nextLine();
        if (cursoIndex >= 0 && cursoIndex < cursoDAO.listarCursos().size()) {
            Aluno aluno = new Aluno(nome, idade, cursoDAO.listarCursos().get(cursoIndex));
            alunoDAO.adicionarAluno(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Curso inválido!");
        }
    }

    private void consultarAluno() {
        System.out.println("Nome do aluno para consulta:");
        String nome = scanner.nextLine();
        Aluno aluno = alunoDAO.buscarAluno(nome);
        if (aluno != null) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Curso: " + aluno.getCurso().getNome());
            System.out.println("Disciplinas:");
            for (Disciplina disciplina : aluno.getCurso().getDisciplinas()) {
                System.out.println("- " + disciplina.getNome());
            }
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private void removerAluno() {
        System.out.println("Nome do aluno para remover:");
        String nome = scanner.nextLine();
        alunoDAO.removerAluno(nome);
        System.out.println("Aluno removido com sucesso!");
    }

    private void atualizarAluno() {
        System.out.println("Nome do aluno para atualizar:");
        String nome = scanner.nextLine();
        Aluno aluno = alunoDAO.buscarAluno(nome);
        if (aluno != null) {
            System.out.println("Novo nome:");
            aluno.setNome(scanner.nextLine());
            System.out.println("Nova idade:");
            aluno.setIdade(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Escolha um novo curso pelo índice:");
            listarCursos();
            int cursoIndex = scanner.nextInt();
            scanner.nextLine();
            if (cursoIndex >= 0 && cursoIndex < cursoDAO.listarCursos().size()) {
                aluno.setCurso(cursoDAO.listarCursos().get(cursoIndex));
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Curso inválido!");
            }
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    // Métodos para gerenciar disciplinas
    private void cadastrarDisciplina() {
        System.out.println("Nome da disciplina:");
        String nome = scanner.nextLine();
        System.out.println("Carga horária da disciplina:");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nota da disciplina:");
        double nota = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Escolha um curso para adicionar a disciplina pelo índice:");
        listarCursos();
        int cursoIndex = scanner.nextInt();
        scanner.nextLine();
        if (cursoIndex >= 0 && cursoIndex < cursoDAO.listarCursos().size()) {
            Disciplina disciplina = new Disciplina(nome, cargaHoraria, nota);
            cursoDAO.listarCursos().get(cursoIndex).getDisciplinas().add(disciplina);
            System.out.println("Disciplina cadastrada com sucesso!");
        } else {
            System.out.println("Curso inválido!");
        }
    }

    private void consultarDisciplina() {
        System.out.println("Nome da disciplina para consulta:");
        String nome = scanner.nextLine();
        Disciplina disciplina = disciplinaDAO.buscarDisciplina(nome);
        if (disciplina != null) {
            System.out.println("Nome: " + disciplina.getNome());
            System.out.println("Carga Horária: " + disciplina.getCargaHoraria());
            System.out.println("Nota: " + disciplina.getNota());
        } else {
            System.out.println("Disciplina não encontrada!");
        }
    }

    private void removerDisciplina() {
        System.out.println("Nome da disciplina para remover:");
        String nome = scanner.nextLine();
        disciplinaDAO.removerDisciplina(nome);
        System.out.println("Disciplina removida com sucesso!");
    }

    private void atualizarDisciplina() {
        System.out.println("Nome da disciplina para atualizar:");
        String nome = scanner.nextLine();
        Disciplina disciplina = disciplinaDAO.buscarDisciplina(nome);
        if (disciplina != null) {
            System.out.println("Novo nome:");
            disciplina.setNome(scanner.nextLine());
            System.out.println("Nova carga horária:");
            disciplina.setCargaHoraria(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Nova nota:");
            disciplina.setNota(scanner.nextDouble());
            scanner.nextLine();
            System.out.println("Disciplina atualizada com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada!");
        }
    }

    // Métodos para gerenciar cursos
    private void cadastrarCurso() {
        System.out.println("Nome do curso:");
        String nome = scanner.nextLine();
        System.out.println("Turno do curso:");
        String turno = scanner.nextLine();
        Curso curso = new Curso(nome, turno);
        cursoDAO.adicionarCurso(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private void consultarCurso() {
        System.out.println("Nome do curso para consulta:");
        String nome = scanner.nextLine();
        Curso curso = cursoDAO.buscarCurso(nome);
        if (curso != null) {
            System.out.println("Nome: " + curso.getNome());
            System.out.println("Turno: " + curso.getTurno());
            System.out.println("Disciplinas:");
            for (Disciplina disciplina : curso.getDisciplinas()) {
                System.out.println("- " + disciplina.getNome());
            }
        } else {
            System.out.println("Curso não encontrado!");
        }
    }

    private void removerCurso() {
        System.out.println("Nome do curso para remover:");
        String nome = scanner.nextLine();
        cursoDAO.removerCurso(nome);
        System.out.println("Curso removido com sucesso!");
    }

    private void atualizarCurso() {
        System.out.println("Nome do curso para atualizar:");
        String nome = scanner.nextLine();
        Curso curso = cursoDAO.buscarCurso(nome);
        if (curso != null) {
            System.out.println("Novo nome:");
            curso.setNome(scanner.nextLine());
            System.out.println("Novo turno:");
            curso.setTurno(scanner.nextLine());
            System.out.println("Curso atualizado com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }
    }

    // Método auxiliar para listar cursos
    private void listarCursos() {
        if (cursoDAO.listarCursos().isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            for (int i = 0; i < cursoDAO.listarCursos().size(); i++) {
                System.out.println(i + " - " + cursoDAO.listarCursos().get(i).getNome());
            }
        }
    }
}