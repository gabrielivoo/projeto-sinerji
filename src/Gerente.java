public class Gerente extends Funcionario {

    double aumentoPorAno = 3000;
    double salarioBase = 20000;
    double beneficio = salarioBase * 0.0;

    public Gerente(String nome, String cargo, int mesContratacao, int anoContratacao) {
        super(nome, cargo, mesContratacao, anoContratacao);
    }
}
