package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;
    private int anoLancamento;


    public Livro() {
        this.avaliacoes = new ArrayList<>();
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("O título do livro não pode ser nulo ou vazio.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("O autor do livro não pode ser nulo ou vazio.");
        }
        if (dataPublicacao == null) {
            throw new ArgumentoInvalidoException("A data de publicação não pode ser nula.");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("A descrição da avaliação não pode ser nula ou vazia.");
        }
        if (qtdEstrelas == null || qtdEstrelas < 0 || qtdEstrelas > 5) {
            throw new ArgumentoInvalidoException("A quantidade de estrelas deve estar entre 0 e 5.");
        }

        avaliacoes.add(new Avaliacao(descricao, qtdEstrelas));
    }

    public Double calcularMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }

        double soma = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.getQtdEstrelas();
        }

        return soma / avaliacoes.size();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", mediaAvaliacoes=" + calcularMediaAvaliacoes() +
                '}';
    }
    public static double getMediaAvaliacoes(Object o) {
        if (o instanceof Livro) {
            Livro livro = (Livro) o;

            List<Avaliacao> avaliacoes = livro.getAvaliacoes();

            if (avaliacoes.isEmpty()) {
                return 0.0;
            }

            double soma = 0.0;
            for (Avaliacao avaliacao : avaliacoes) {
                soma += avaliacao.getNota();
            }

            return soma / avaliacoes.size();
        }

        throw new IllegalArgumentException("O objeto fornecido não é uma instância de Livro");
    }

    private List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public int getAnoLancamento() {
        return this.anoLancamento; // Assumindo que o atributo seja chamado 'anoLancamento'
    }

}
