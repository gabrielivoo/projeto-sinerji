import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando funcionários
        Funcionario gerente = new Gerente("Juliana Alves", "Gerente", 7, 2017);
        Funcionario gerente1 = new Gerente("Bento Albino", "Gerente", 3, 2014);
        Funcionario secretario = new Secretario("Jorge Carvalho", "Secretário", 1, 2018);
        Funcionario secretario1 = new Secretario("Maria Souza", "Secretário", 12, 2015);
        Funcionario vendedor = new Vendedor("Ana Silva", "Vendedor", 12, 2021);
        Funcionario vendedor1 = new Vendedor("João Mendes", "Vendedor", 12, 2021);

        // Adicionando vendas Ana
        vendedor.adicionarVenda(5200, 12, 2021);
        vendedor.adicionarVenda(4000, 1, 2022);
        vendedor.adicionarVenda(4200, 2, 2022);
        vendedor.adicionarVenda(5850, 3, 2022);
        vendedor.adicionarVenda(7000, 4, 2022);
        // Adicionando vendas Joao
        vendedor1.adicionarVenda(3400, 12, 2021);
        vendedor1.adicionarVenda(7700, 1, 2022);
        vendedor1.adicionarVenda(53200, 2, 2022);
        vendedor1.adicionarVenda(5900, 3, 2022);
        vendedor1.adicionarVenda(6500, 4, 2022);

        // Criando lista de todos os funcionários
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios.add(gerente);
        listaFuncionarios.add(gerente1);
        listaFuncionarios.add(vendedor);
        listaFuncionarios.add(vendedor1);
        listaFuncionarios.add(secretario);
        listaFuncionarios.add(secretario1);

        // Criando lista de todos os funcionários com beneficio
        List<Funcionario> listaFuncionariosBeneficio = new ArrayList<>();
        listaFuncionariosBeneficio.add(secretario);
        listaFuncionariosBeneficio.add(secretario1);
        listaFuncionariosBeneficio.add(vendedor);
        listaFuncionariosBeneficio.add(vendedor1);

        // Criando lista de vendas
        List<Venda> vendasVendedor = new ArrayList<>();
        vendasVendedor.addAll(vendedor.getVendas());
        vendasVendedor.addAll(vendedor1.getVendas());

        // Primeiro tópico Calculando salários + beneficios
        double valorTotal = gerente.calculaSalarioComBeneficios(listaFuncionarios, vendasVendedor, 1, 2022);
        System.out.println("Valor total pago no mês: " + valorTotal);

        // Segundo Tópico Calculando salários
        double salarioTotal = gerente.calculaSalario(listaFuncionarios, 2, 2022);
        System.out.println("Salário total pago no mês: " + salarioTotal);

        // Terceiro tópico Calculando salario
        double beneficioTotal = gerente.calculaSomaBeneficios(listaFuncionariosBeneficio, vendasVendedor, 1, 2022);
        System.out.println("Benefício total: " + beneficioTotal);

        // QUarto tópico Calculando maior salario
        String maiorSalario = gerente.calculaMaiorSalario(listaFuncionarios, vendasVendedor, 2, 2022);
        System.out.println(maiorSalario);

        // Quinto tópico Calculando maior salario
        String maiorBeneficio = gerente.calculaMaiorBeneficio(listaFuncionariosBeneficio, vendasVendedor, 2, 2022);
        System.out.println(maiorBeneficio);

        // Sexto Tópico Calculando mais vendas
        String maisVendas = gerente.calculaMaiorVendedor(vendasVendedor, 2, 2022);
        System.out.println(maisVendas);
    }
}
