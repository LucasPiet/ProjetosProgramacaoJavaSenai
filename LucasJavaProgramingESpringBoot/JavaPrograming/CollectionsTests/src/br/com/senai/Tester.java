package br.com.senai;


import java.util.*;


public class Tester {
    static void main(String[] args) {
//        List<Livro> livros = new ArrayList<>();
//        Livro livro1 = new Livro();
//        livro1.setCodigo(1);
//        livro1.setTitulo("O senhor dos anéis");
//        livro1.setAutor("J. R. R. Tolkien");
//
//        livros.add(livro1);
//
//        Livro livro2 = new Livro(2,"Harry potter","J. K. Rolling");
//
//        livros.add(livro2);
//
//        livros.add(new Livro(3,"Dom Casmugo","Machado de Assis"));
//
//        livros.add(new Livro());
//
//        System.out.println(livros);
//
//        livros.get(3).setTitulo("Star war");
//        livros.get(3).setCodigo(4);
//        livros.get(3).setAutor("Geoge Lucas");
//
//        System.out.println(livros);
//        System.out.println();
//        livros.sort(Comparator.comparing(Livro::getTitulo));
//        System.out.println(livros);
//        Set<Email> contatos = new HashSet<>();
//
//        Email email1 = new Email("lucas.mauri@gmail.com");
//        contatos.add(email1);
//
//        Email email2 = new Email();
//
//        email2.setEndereco("lucaspietscher@gmail.com");
//        contatos.add(email2);
//
//        contatos.addAll(List.of(
//                new Email("tina.rossa@gmail.com"),
//                new Email("leandro.silva@gmail.com")
//        ));
//        contatos.add(new Email("lucaspietscher@gmail.com"));
//        for (Email contato : contatos){
//            System.out.println(contato);
//        }
//        Set<String> emails = new HashSet<>();
//        emails.addAll(List.of(
//                new String("tina.rossa@gmail.com"),
//                new String("leandro.silva@gmail.com"),
//                new String("tina.rossa@gmail.com"),
//                new String("leandro.silva@gmail.com")
//        ));
//        System.out.println();
//        for (String email : emails){
//            System.out.println(email);
//        }
//        Set<Integer> notas = new TreeSet<>();
//        notas.addAll(List.of(
//                new Integer(1),
//                new Integer(2),
//                new Integer(5),
//                new Integer(10),
//                new Integer(20),
//                new Integer(50),
//                new Integer(100),
//                new Integer(200)
//        ));
//        for (int nota : notas){
//            System.out.println(nota);
//        }
//        Map<String,Livro> emprestimos = new HashMap<>();
//        emprestimos.put("Carlos",livro1);
//        emprestimos.put("Lucas", livros.get(2));
        Queue<String> filaLetras = new LinkedList<>();

        filaLetras.add("A");
        filaLetras.add("B");
        filaLetras.add("C");
        filaLetras.add("D");
        filaLetras.add("E");
        filaLetras.add("F");
        filaLetras.add("G");
        filaLetras.add("H");
        filaLetras.add("I");
        filaLetras.add("J");
        filaLetras.add("K");
        filaLetras.add("L");
        filaLetras.add("M");
        filaLetras.add("N");

        PriorityQueue<Integer> filaPrioritaria = new PriorityQueue<>();

        filaPrioritaria.add(1);
        filaPrioritaria.add(2);
        filaPrioritaria.add(5);
        filaPrioritaria.add(3);
        filaPrioritaria.add(4);
        filaPrioritaria.add(6);
        filaPrioritaria.add(8);
        filaPrioritaria.add(7);

        while (!filaPrioritaria.isEmpty()) {
            filaPrioritaria.poll();
        }
        System.out.println(filaPrioritaria);
    }
}
