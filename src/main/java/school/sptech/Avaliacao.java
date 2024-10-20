package school.sptech;

public class Avaliacao {
    private String descricao;
    private Double qtdEstrelas;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQtdEstrelas(Double qtdEstrelas) {
        this.qtdEstrelas = qtdEstrelas;
    }

    public Avaliacao() {

    }

    public Avaliacao(String descricao, Double qtdEstrelas) {
        this.descricao = descricao;
        this.qtdEstrelas = qtdEstrelas;
    }

    @Override
    public String toString() {
        return "Avaliacao: " + descricao + " - Estrelas: " + qtdEstrelas;
    }

    public Double getQtdEstrelas() {
        return qtdEstrelas;
    }

    public double getNota() {
        return qtdEstrelas / qtdEstrelas;
    }
}

