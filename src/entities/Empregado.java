package entities;

public class Empregado {
    private int id;
    private String nome;
    private double salario;

    public Empregado(int id, String nome, double salario) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID deve ser maior que zero.");
        }
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }


    public void aumentarSalarioPorPorcentagem(double porcentagem) {
        this.salario += this.salario * (porcentagem / 100);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
