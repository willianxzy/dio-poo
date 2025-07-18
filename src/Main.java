import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {

        Curso curso = new Curso("Java", "Aprenda os fundamentos de Java", 40);
        Curso curso2 = new Curso("JavaScript", "Aprenda os fundamentos de JavaScript", 30);

        Mentoria mentoria = new Mentoria("Mentoria de Java", "Sessão de mentoria sobre Java", LocalDate.now());

        Conteudo conteudo1 = new Curso("Python", "Aprenda os fundamentos de Python", 50);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp de Programação");
        bootcamp.setDescricao("Aprenda as principais linguagens de programação");
        bootcamp.setDataInicial(LocalDate.now());
        bootcamp.setDataFinal(LocalDate.now().plusDays(30));
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(conteudo1);

        Dev dev1 = new Dev();
        dev1.setNome("Willian");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos" + dev1.getConteudosInscritos());
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        System.out.println("Conteúdos Concluídos" + dev1.getConteudosConcluidos());

        Dev dev2 = new Dev();
        dev2.setNome("Pedro");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos" + dev2.getConteudosInscritos());
        dev2.progredir();
        System.out.println("Conteúdos Concluídos" + dev2.getConteudosConcluidos());
        System.out.println("XP de " + dev1.getNome() + ": " + dev1.calcularXP());
        System.out.println("XP de " + dev2.getNome() + ": " + dev2.calcularXP());

    }
}