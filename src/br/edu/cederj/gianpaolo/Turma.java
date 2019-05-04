package br.edu.cederj.gianpaolo;

import java.util.LinkedList;
import java.util.List;

public class Turma {
    private String nome;
    private String codigo;
    private String periodo;
    private List<Aluno> alunos;

    public Turma(String nome, String codigo, String periodo) {
        this.nome = nome;
        this.codigo = codigo;
        this.periodo = periodo;
        this.alunos = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void inserirAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        String s = "Turma: " + nome + '\n' +
                "Código: " + codigo + '\n' +
                "Período: " + periodo + '\n' +
                "Alunos:\n";
        for(Aluno aluno: alunos){
            s += aluno.toString();
            s += '\n';
        }
        return s;
    }

    public void imprimir(){
        System.out.println(this);
    }
}
