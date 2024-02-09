import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    protected String nome;
    protected String cargo;
    protected int mesContratacao;
    protected int anoContratacao;

    protected List<Venda> vendas;

    public Funcionario(String nome, String cargo, int mesContratacao, int anoContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.mesContratacao = mesContratacao;
        this.anoContratacao = anoContratacao;
        this.vendas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getMesContratacao() {
        return mesContratacao;
    }

    public void setMesContratacao(int mesContratacao) {
        this.mesContratacao = mesContratacao;
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public void setAnoContratacao(int anoContratacao) {
        this.anoContratacao = anoContratacao;
    }
    public void adicionarVenda(double valor, int mes, int ano) {
        Venda venda = new Venda(nome, valor, mes, ano);
        vendas.add(venda);
    }
    public List<Venda> getVendas() {
        return vendas;
    }
    public double calculaSalarioComBeneficios(List<Funcionario> lista_funcionarios, List<Venda> todasVendas, int mes, int ano){
        double valorTotal = 0.0;
        for (Funcionario funcionario : lista_funcionarios) {
            if (funcionario.getAnoContratacao() < ano || (funcionario.getAnoContratacao() == ano && funcionario.getMesContratacao() <= mes)) {
                int anosTrabalhados = ano - funcionario.getAnoContratacao();
                if (mes < funcionario.getMesContratacao()) {
                    anosTrabalhados--;
                }
                switch (funcionario) {
                    case Gerente gerente -> {
                        double aumentoTotal = gerente.aumentoPorAno * anosTrabalhados;
                        valorTotal += gerente.salarioBase + aumentoTotal + gerente.beneficio;
                    }
                    case Secretario secretario -> {
                        double aumentoTotal = secretario.aumentoPorAno * anosTrabalhados;
                        valorTotal += secretario.salarioBase + aumentoTotal + secretario.beneficio;
                    }
                    case Vendedor vendedor -> {
                        double aumentoTotal = vendedor.aumentoPorAno * anosTrabalhados;
                        double beneficioVenda = 0;
                        for (Venda venda : todasVendas) {
                            if (venda.getAno() == ano && venda.getMes() == mes && venda.getNome() == ((Vendedor) funcionario).getNome()) {
                                beneficioVenda += venda.getValor() * 0.3;
                            }
                        }
                        valorTotal += vendedor.salarioBase + aumentoTotal + beneficioVenda;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + funcionario);
                }
            }
        }
        return valorTotal;
    }


    public double calculaSalario(List<Funcionario> lista_funcionarios, int mes, int ano){
        double salarioTotal = 0.0;
        for (Funcionario funcionario : lista_funcionarios) {
            if (funcionario.getAnoContratacao() < ano || (funcionario.getAnoContratacao() == ano && funcionario.getMesContratacao() <= mes)) {
                int anosTrabalhados = ano - funcionario.getAnoContratacao();
                if (mes < funcionario.getMesContratacao()) {
                    anosTrabalhados--;
                }
                if (funcionario instanceof Gerente) {
                    double aumentoTotal = ((Gerente) funcionario).aumentoPorAno * anosTrabalhados;
                    salarioTotal += ((Gerente) funcionario).salarioBase + aumentoTotal;
                } else if (funcionario instanceof Secretario) {
                    double aumentoTotal = ((Secretario) funcionario).aumentoPorAno * anosTrabalhados;
                    salarioTotal += ((Secretario) funcionario).salarioBase + aumentoTotal;
                } else if (funcionario instanceof Vendedor) {
                    double aumentoTotal = ((Vendedor) funcionario).aumentoPorAno * anosTrabalhados;
                    salarioTotal += ((Vendedor) funcionario).salarioBase + aumentoTotal;
                }
            }
        }
        return salarioTotal;
    }

    public double calculaSomaBeneficios(List<Funcionario> todosFuncionarios, List<Venda> todasVendas, int mes, int ano) {
        double beneficioTotal = 0.0;
        for (Funcionario funcionario : todosFuncionarios) {
            if (funcionario instanceof Vendedor) {
                for (Venda venda : todasVendas) {
                    if (venda.getAno() == ano && venda.getMes() == mes && venda.getNome() == ((Vendedor) funcionario).getNome()) {
                        beneficioTotal += venda.getValor() * 0.3;
                    }
                }
            } else if (funcionario instanceof Secretario) {
                beneficioTotal += ((Secretario) funcionario).beneficio;
            }
        }
        return beneficioTotal;
    }
    public String calculaMaiorSalario(List<Funcionario> todosFuncionarios, List<Venda> todasVendas, int mes, int ano) {
        String nomeMaiorSalario = "";
        double maiorSalario = Double.MIN_VALUE;

        for (Funcionario funcionario : todosFuncionarios) {
            double salarioTotal = 0.0;

            if (funcionario.getAnoContratacao() < ano || (funcionario.getAnoContratacao() == ano && funcionario.getMesContratacao() <= mes)) {
                int anosTrabalhados = ano - funcionario.getAnoContratacao();
                if (mes < funcionario.getMesContratacao()) {
                    anosTrabalhados--;
                }
                switch (funcionario) {
                    case Gerente gerente -> {
                        double aumentoTotal = gerente.aumentoPorAno * anosTrabalhados;
                        salarioTotal += gerente.salarioBase + aumentoTotal + gerente.beneficio;
                    }
                    case Secretario secretario -> {
                        double aumentoTotal = secretario.aumentoPorAno * anosTrabalhados;
                        salarioTotal += secretario.salarioBase + aumentoTotal + secretario.beneficio;
                    }
                    case Vendedor vendedor -> {
                        double aumentoTotal = vendedor.aumentoPorAno * anosTrabalhados;
                        double beneficioVenda = 0.0;
                        for (Venda venda : todasVendas) {
                            if (venda.getAno() == ano && venda.getMes() == mes && venda.getNome().equals(funcionario.getNome())) {
                                beneficioVenda += venda.getValor() * 0.3; // 30% do valor da venda como benefício
                            }
                        }
                        salarioTotal += vendedor.salarioBase + aumentoTotal + beneficioVenda;
                    }
                    default -> {
                    }
                }
            }
            if (salarioTotal > maiorSalario) {
                maiorSalario = salarioTotal;
                nomeMaiorSalario = funcionario.getNome();
            }
        }
        return "O maior salário do mês foi de " + nomeMaiorSalario + " com o salário total de R$" + maiorSalario + ".";
    }

    public String calculaMaiorBeneficio(List<Funcionario> todosFuncionarios, List<Venda> todasVendas, int mes, int ano) {
        String nomeMaiorBeneficio = "";
        double maiorBeneficio = Double.MIN_VALUE;

        for (Funcionario funcionario : todosFuncionarios) {
            double beneficioTotal = 0.0;
            if (funcionario instanceof Vendedor) {
                for (Venda venda : todasVendas) {
                    if (venda.getAno() == ano && venda.getMes() == mes && venda.getNome() == ((Vendedor) funcionario).getNome()) {
                        beneficioTotal += venda.getValor() * 0.3;
                    }
                }
            } else if (funcionario instanceof Secretario) {
                beneficioTotal = ((Secretario) funcionario).beneficio;
            }

            if (beneficioTotal > maiorBeneficio) {
                maiorBeneficio = beneficioTotal;
                nomeMaiorBeneficio = funcionario.getNome();
            }
        }
        return "O funcionário com o maior benefício do mês foi " + nomeMaiorBeneficio + " com um total de R$" + maiorBeneficio + ".";
    }

    public String calculaMaiorVendedor(List<Venda> todasVendas, int mes, int ano) {
        String nomeMaiorVendedor = "";
        int maiorQuantidadeVendas = 0;

        for (Venda venda : todasVendas) {
            if (venda.getMes() == mes && venda.getAno() == ano) {
                String nomeVendedor = venda.getNome();
                int quantidadeVendas = 1;
                for (Venda outraVenda : todasVendas) {
                    if (outraVenda != venda && outraVenda.getNome().equals(nomeVendedor) &&
                            outraVenda.getMes() == mes && outraVenda.getAno() == ano) {
                        quantidadeVendas++;
                    }
                }
                if (quantidadeVendas > maiorQuantidadeVendas) {
                    nomeMaiorVendedor = nomeVendedor;
                    maiorQuantidadeVendas = quantidadeVendas;
                }
            }
        }
        return "O vendedor que mais vendeu no mês foi " + nomeMaiorVendedor + " com um total de " + maiorQuantidadeVendas + " vendas.";
    }

}
