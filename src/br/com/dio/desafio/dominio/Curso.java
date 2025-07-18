package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        setTitulo(titulo);
        setDescricao(descricao);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO + (cargaHoraria * 10);
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso: {" + "\n"
        + "titulo: " + getTitulo() + "\n"
        + "descricao: " + getDescricao() + "\n"
        + "cargaHoraria: " + cargaHoraria + " Horas" + "\n"
        + "}";
    }

}
