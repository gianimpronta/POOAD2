package br.edu.cederj.gianpaolo;

import java.util.HashMap;
import java.util.TreeSet;

public class Pauta {
    Turma turma;
    int mesInicial;
    int mesFinal;
    int maxFaltas;

    private HashMap<Integer, HashMap<Integer, TreeSet<Integer>>> faltas;


    public Pauta(int mesInicial, int mesFinal, Turma turma) {
        this.turma = turma;
        this.mesInicial = mesInicial;
        this.mesFinal = mesFinal;
        this.maxFaltas = (int) Math.ceil((mesFinal-mesInicial+1)*30*0.25);
        this.faltas = new HashMap<>();
        for (Aluno aluno:turma.getAlunos()){
            HashMap<Integer, TreeSet<Integer>> mesAluno = new HashMap<>();
            for (int i=mesInicial; i<=mesFinal; i++){
                mesAluno.put(i, new TreeSet<>());
            }
            faltas.put(aluno.getMatricula(), mesAluno);
        }
    }


    void marcarFalta(int matricula, int mes, int dia){
        if (mes < mesInicial || mes > mesFinal){
            System.out.println("O mês desejado está fora da faixa da pauta");
            return;
        }
        try {
            HashMap<Integer, TreeSet<Integer>> faltasAtual = faltas.get(matricula);
            faltasAtual.get(mes).add(dia);
        } catch (NullPointerException e){
            System.out.println("Esta matrícula não existe!");
        }
    }

    int totalFaltasAluno(int matricula){
        int totalFaltas = 0;
        try {
            for (Integer key:faltas.get(matricula).keySet()){
                totalFaltas += faltas.get(matricula).get(key).size();
            }
        } catch (NullPointerException e){
            System.out.println("Esta matrícula não existe!");
        }
        return totalFaltas;
    }

    boolean verificarReprovacaoPorFalta(int matricula){
        return totalFaltasAluno(matricula) > maxFaltas;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Turma: " + turma.getNome() + ' ' + turma.getCodigo() + ' ' +
                turma.getPeriodo() + '\n';
        s += "Essa pauta vai do mês "+ mesInicial + " ao mês " + mesFinal + '\n';
        s += "-----------------------------------------------------------\n";
        for (Integer aluno:faltas.keySet()){
            Aluno a = null;
            for (int i=0;i<turma.getAlunos().size();i++){
                if (turma.getAlunos().get(i).getMatricula() == aluno){
                    a = turma.getAlunos().get(i);
                }
            }
            for (int i=mesInicial; i<=mesFinal;i++){
                s += a.getNome() + " faltou no mês " + i + " nos dias " +
                        faltas.get(aluno).get(i) + "\n";
            }
        }
        return s;
    }

    public void imprimir(){
        System.out.println(this);
    }
}
