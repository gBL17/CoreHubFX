package br.com.corehub.agibank.corefx.beans.conta;

public class Taxa {

    private int id;
    private int classe;
    private String descricao;
    private double valor;

    public Taxa() {}

    public Taxa(int id, int classe, String descricao, double valor) {
        this.id = id;
        this.classe = classe;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Taxa(int classe, String descricao, double valor) {
        this.classe = classe;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
