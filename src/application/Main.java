package application;

import entities.Empregado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Empregado> empregados = new ArrayList<>();

        System.out.print("Quantos empregados vão ser registrados? ");
        int numeroEmpregados = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numeroEmpregados; i++) {
            System.out.println("Empregado " + (i + 1) + ":");

            int id;
            while (true) {
                System.out.print("ID: ");
                id = sc.nextInt();
                sc.nextLine();

                boolean idExistente = false;
                for (Empregado emp : empregados) {
                    if (emp.getId() == id) {
                        idExistente = true;
                        break;
                    }
                }

                if (!idExistente) {
                    break;
                }
                System.out.println("ID já cadastrado! Digite um diferente.");
            }

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Salário: ");
            double salario = sc.nextDouble();
            sc.nextLine();

            empregados.add(new Empregado(id, nome, salario));
        }

        System.out.print("Qual o ID do funcionário que você quer dar um aumento? ");
        int idFuncionario = sc.nextInt();
        sc.nextLine();

        Empregado empregado = null;
        for (Empregado emp : empregados) {
            if (emp.getId() == idFuncionario) {
                empregado = emp;
                break;
            }
        }

        if (empregado != null) {
            System.out.print("Digite a porcentagem de aumento: ");
            double porcentagem = sc.nextDouble();

            empregado.aumentarSalarioPorPorcentagem(porcentagem);
            System.out.println("Novo salário de " + empregado.getNome() + ": R$ " + empregado.getSalario());
        } else {
            System.out.println("Funcionário não encontrado!");
        }

        sc.close();
    }
}
