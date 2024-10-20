package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("Nome da biblioteca não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            throw new ArgumentoInvalidoException("Livro não pode ser nulo.");
        }
        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new ArgumentoInvalidoException("Título do livro não pode ser nulo ou vazio.");
        }
      
        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("Título do livro não pode ser nulo ou vazio.");
        }

        Livro livroParaRemover = buscarLivroPorTitulo(titulo);
        livros.remove(livroParaRemover);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("Título não pode ser nulo ou vazio.");
        }

        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new LivroNaoEncontradoException("Livro com título '" + titulo + "' não encontrado."));
    }

    public int contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        if (ano == null || ano <= 0) {
            throw new ArgumentoInvalidoException("Ano inválido.");
        }

        List<Livro> livrosAteAno = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAnoLancamento() <= ano) {
                livrosAteAno.add(livro);
            }
        }
        return livrosAteAno;
    }

    public List<Livro> retornarTopCincoLivros() {
        return livros.stream()
                .sorted(Comparator.comparingDouble(Livro::getMediaAvaliacoes).reversed())
                .limit(5)
                .toList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("Nome da biblioteca não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }
}
