import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {
    protected double aumentoPorAno = 1800;
    protected double salarioBase = 12000;

    public Vendedor(String nome, String cargo, int mesContratacao, int anoContratacao) {
        super(nome, cargo, mesContratacao, anoContratacao);
    }

    @Override
    public void adicionarVenda(double valor, int mes, int ano) {
        super.adicionarVenda(valor, mes, ano);
    }

}
