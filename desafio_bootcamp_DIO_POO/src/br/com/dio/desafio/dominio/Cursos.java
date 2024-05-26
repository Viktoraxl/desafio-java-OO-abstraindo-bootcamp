package br.com.dio.desafio.dominio;

public class Cursos extends Conteudos{
	
	private int cargaHoraria;
	
	@Override
	public double calcularXP() {
		return XP_PADRAO * cargaHoraria;
	}
	
	public Cursos cadastrarCurso(String titulo, String descricao, int cargaHoraria) {
		setTitulo(titulo);
		setDescricao(descricao);
		setCargaHoraria(cargaHoraria);
		return this;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
    public String toString() {
        return getTitulo() + ", Descrição: " + getDescricao() + ", Carga Horária: " + cargaHoraria + " horas";
    }	
}
