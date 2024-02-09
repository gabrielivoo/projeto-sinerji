class Venda {
    private String nome;
    private double valor;
    private int mes;
    private int ano;

    public Venda(String nome, double valor, int mes, int ano) {
        this.nome = nome;
        this.valor = valor;
        this.mes = mes;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
}