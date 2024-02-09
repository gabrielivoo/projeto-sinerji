public class Secretario extends Funcionario {
    double aumentoPorAno = 1000;
    double salarioBase = 7000;
    double beneficio = salarioBase * 0.2;
    public Secretario(String nome, String cargo, int mesContratacao, int anoContratacao) {
        super(nome, cargo, mesContratacao, anoContratacao);
    }
}
