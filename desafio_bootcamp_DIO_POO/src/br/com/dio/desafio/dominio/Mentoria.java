package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudos{
	private LocalDate data;
	
	public Mentoria() {		
	}
	
	@Override
	public double calcularXP() {
		return XP_PADRAO + 20d;
	}
	
	public Mentoria cadastrarMentoria(String titulo, String descricao, LocalDate data) {
		setTitulo(titulo);
		setDescricao(descricao);
		setData(data);
		return this;
	}

	public LocalDate getData() {
		return data;
	}

	public Mentoria setData(LocalDate data) {
		this.data = data;
		return null;
	}
	
	@Override
    public String toString() {
        return getTitulo() + ", Descrição: " + getDescricao() + ", Data: " + data;
    }	
}
