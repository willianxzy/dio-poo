package br.com.dio.desafio.dominio;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    public Mentoria(String titulo, String descricao, LocalDate data) {
        setTitulo(titulo);
        setDescricao(descricao);
        this.data = data;
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String formatData() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(java.sql.Date.valueOf(data));
    }

    @Override
    public String toString() {
        return "Mentoria: {" + "\n"
        + "titulo: " + getTitulo() + "\n"
        + "descricao: " + getDescricao() + "\n"
        + "data: " + formatData() + "\n"
        + "}";
    }

}
