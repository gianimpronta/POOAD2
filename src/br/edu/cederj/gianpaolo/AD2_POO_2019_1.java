package br.edu.cederj.gianpaolo;

public class AD2_POO_2019_1{
    public static void main(String[] args){
        Turma turma = new Turma("Est. de dados","A1","20191");
        turma.inserirAluno(new Aluno("Anselmo",111));
        turma.inserirAluno(new Aluno("Pedro",222));
        turma.inserirAluno(new Aluno("Joao",333));
        turma.imprimir();
        System.out.println("------------------------------------------");
        Pauta pauta = new Pauta(3,6,turma);
        pauta.marcarFalta(111, 3, 5);
        pauta.marcarFalta(111, 3, 12);
        pauta.marcarFalta(111, 3, 21);
        pauta.marcarFalta(111, 3, 26);
        pauta.marcarFalta(111, 4, 2);
        pauta.marcarFalta(111, 4, 4);
        pauta.marcarFalta(111, 4, 11);
        pauta.marcarFalta(111, 4, 23);
        pauta.marcarFalta(111, 4, 25);
        pauta.marcarFalta(111, 4, 30);
        pauta.marcarFalta(111, 5, 7);
        pauta.marcarFalta(111, 5, 23);
        pauta.marcarFalta(222, 3, 12);
        pauta.marcarFalta(222, 3, 21);
        pauta.marcarFalta(222, 4, 9);
        pauta.marcarFalta(222, 4, 16);
        pauta.marcarFalta(222, 4, 25);
        pauta.marcarFalta(222, 4, 30);
//        Teste para dias repetidos
//        pauta.marcarFalta(222, 4, 30);

//        Teste para mês fora da faixa
//        pauta.marcarFalta(222, 7, 30);

//        Teste para matrícula inexistente
//        pauta.marcarFalta(444, 3, 30);
        pauta.imprimir();
        for(Aluno aluno:turma.getAlunos()){
            int totalFaltas = pauta.totalFaltasAluno(aluno.getMatricula());
            System.out.print(String.format("%-44s", aluno.toString()) + " "
                    + "#faltas = " + String.format("%2d",totalFaltas));
            if (pauta.verificarReprovacaoPorFalta(aluno.getMatricula())){
                System.out.println(" Presença: reprovado");
            }
            else{
                System.out.println(" Presença: normal");
            }
        }
    }
}