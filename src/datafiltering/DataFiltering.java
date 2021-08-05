package datafiltering;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class DataFiltering {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/Base de Alunos1.csv"));
        FileOutputStream fileOutput = new FileOutputStream("src/item.csv");
        DataOutputStream output = new DataOutputStream(fileOutput);
        LinkedList<Pessoa> alunos = new LinkedList<Pessoa>();
        LinkedList<Pessoa> dengue = new LinkedList<Pessoa>();
        LinkedList<Pessoa> onibus = new LinkedList<Pessoa>();

        int cont = 0;

        //Leitura de arquivos
        while (br.ready()) {
            String linha = br.readLine();

            if (cont > 0) {
                String x[] = linha.split(";");

                Pessoa p = new Pessoa();

                p.setId(x[0]);
                p.setNome(x[1]);
                p.setPai(x[2]);
                p.setMae(x[3]);
                p.setSexo(x[4]);
                p.setData(x[5]);

                alunos.add(p);
            }
            cont++;
        }

        br.close();

        br = new BufferedReader(new FileReader("src/Base de Dengue1.csv"));

        cont = 0;

        while (br.ready()) {
            String linha = br.readLine();

            if (cont > 0) {
                String x[] = linha.split(";");

                Pessoa p = new Pessoa();

                p.setId(x[0]);
                p.setNome(x[1]);
                p.setPai(x[2]);
                p.setMae(x[3]);
                p.setSexo(x[4]);
                p.setData(x[5]);
                p.setDengueOnibus(x[6]);

                dengue.add(p);
            }

            cont++;
        }

        br.close();

        br = new BufferedReader(new FileReader("src/Base de Onibus1.csv"));

        cont = 0;

        while (br.ready()) {
            String linha = br.readLine();

            if (cont > 0) {
                String x[] = linha.split(";");

                Pessoa p = new Pessoa();

                p.setId(x[0]);
                p.setNome(x[1]);
                p.setPai(x[2]);
                p.setMae(x[3]);
                p.setSexo(x[4]);
                p.setData(x[5]);
                p.setDengueOnibus(x[6]);

                onibus.add(p);
            }

            cont++;
        }

        br.close();

        //Seleção de item a ser gerado o arquivo com o resultado
        int item = 7;

        switch (item) {
            case 1:
                databaseFilter(dengue, alunos, output, 1);
                break;
            case 2:
                databaseFilter(onibus, dengue, output, 2);
                break;
            case 3:
                databaseFilter(dengue, onibus, output, 3);
                break;
            case 4:
                databaseFilter(alunos, dengue, output, 4);
                break;
            case 5:
                databaseFilter(alunos, onibus, output, 5);
                break;
            case 6:
                databaseFilter(dengue, onibus, output, 6);
                break;
            case 7:
                databaseFilter(dengue, onibus, alunos, output, 7);
                break;
            case 8:
                databaseFilter(onibus, dengue, output, 8);
                break;
            case 9:
                databaseFilter(alunos, dengue, output, 9);
                break;
            case 10:
                databaseFilter(onibus, dengue, alunos, output, 10);
                break;
        }
    }

    //Metodos para tratatamento de saida
    public static void databaseFilter(LinkedList<Pessoa> arquivo1, LinkedList<Pessoa> arquivo2, DataOutputStream output, int item) throws IOException {
        LinkedList resultado[] = compareDatabase(arquivo1, arquivo2, output, item);
        LinkedList<Pessoa> dataResult = resultado[0];
        LinkedList<Pessoa> filterResult = resultado[1];

        String array[] = new String[dataResult.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = "";
        }

        int cont = 1;
        int cont0 = 0;

        switch (item) {
            case 1:
                System.out.println("ID;Nome;Data de Nascimento");

                for (Pessoa p : filterResult) {
                    System.out.println(cont + " - " + p.getId() + ";" + p.getNome() + ";" + p.getData());

                    cont++;
                }

                for (Pessoa p : dataResult) {
                    array[cont0] = p.getId() + ";";
                    array[cont0] += p.getNome() + ";";
                    array[cont0] += p.getData() + "\n";

                    cont0++;
                }

                output.writeChars("ID;Nome;Data de Nascimento\n");

                for (int i = 0; i < array.length; i++) {
                    output.writeChars(array[i]);
                }

                break;
            case 2:
            case 4:
            case 8:
            case 9:
                System.out.println("Nome;Data de Nascimento;Data da Dengue");

                for (Pessoa p : filterResult) {
                    System.out.println(cont + " - " + p.getId() + ";" + p.getNome() + ";" + p.getData() + ";" + p.getDengueOnibus());

                    cont++;
                }

                for (Pessoa p : dataResult) {
                    array[cont0] = p.getId() + ";";
                    array[cont0] += p.getNome() + ";";
                    array[cont0] += p.getData() + ";";
                    array[cont0] += p.getDengueOnibus() + "\n";

                    cont0++;
                }

                output.writeChars("ID;Nome;Data de Nascimento;Data da Dengue\n");

                for (int i = 0; i < array.length; i++) {
                    output.writeChars(array[i]);
                }

                break;
            case 3:
            case 5:
                System.out.println("ID;Nome;Data de Nascimento;Linha de Ônibus");

                for (Pessoa p : filterResult) {
                    System.out.println(cont + " - " + p.getId() + ";" + p.getNome() + ";" + p.getData() + ";" + p.getDengueOnibus());

                    cont++;
                }

                for (Pessoa p : dataResult) {
                    array[cont0] = p.getId() + ";";
                    array[cont0] += p.getNome() + ";";
                    array[cont0] += p.getData() + ";";
                    array[cont0] += p.getDengueOnibus() + "\n";

                    cont0++;
                }

                output.writeChars("ID;Nome;Data de Nascimento;Linha de Onibus\n");

                for (int i = 0; i < array.length; i++) {
                    output.writeChars(array[i]);
                }

                break;

            case 6:
                System.out.println("ID;Nome;Data de Nascimento;Data da Dengue;Linha de Ônibus");

                for (Pessoa p : filterResult) {
                    System.out.println(cont + " - " + p.getId() + ";" + p.getNome() + ";" + p.getData() + ";" + p.getDengueOnibus() + ";" + p.getOnibus());

                    cont++;
                }

                for (Pessoa p : dataResult) {
                    array[cont0] = p.getId() + ";";
                    array[cont0] += p.getNome() + ";";
                    array[cont0] += p.getData() + ";";
                    array[cont0] += p.getDengueOnibus() + ";";
                    array[cont0] += p.getOnibus() + "\n";

                    cont0++;
                }

                output.writeChars("ID;Nome;Data de Nascimento;Data da Dengue;Linha de Ônibus\n");

                for (int i = 0; i < array.length; i++) {
                    output.writeChars(array[i]);
                }

                break;
        }

        output.close();
    }

    public static void databaseFilter(LinkedList<Pessoa> arquivo1, LinkedList<Pessoa> arquivo2, LinkedList<Pessoa> arquivo3, DataOutputStream output, int item) throws IOException {
        LinkedList resultado[] = compareDatabase(arquivo1, arquivo2, arquivo3, output, item);
        LinkedList<Pessoa> dataResult = resultado[0];
        LinkedList<Pessoa> filterResult = resultado[1];

        String array[] = new String[dataResult.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = "";
        }

        int cont = 1;
        int cont0 = 0;

        switch (item) {
            case 7:
                System.out.println("ID;Nome;Data de Nascimento;Data da Dengue;Linha de Ônibus");

                for (Pessoa p : dataResult) {
                    array[cont0] = p.getId() + ";";
                    array[cont0] += p.getNome() + ";";
                    array[cont0] += p.getData() + ";";
                    array[cont0] += p.getDengueOnibus() + ";";
                    array[cont0] += p.getOnibus() + "\n";

                    cont0++;
                }

                output.writeChars("ID;Nome;Data de Nascimento;Data da Dengue;Linha de Ônibus\n");

                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                    output.writeChars(array[i]);
                }

                break;
            case 10:
                System.out.println("Nome;Data de Nascimento;Data da Dengue");

                for (Pessoa p : filterResult) {
                    System.out.println(cont + " - " + p.getId() + ";" + p.getNome() + ";" + p.getData() + ";" + p.getDengueOnibus());

                    cont++;
                }

                for (Pessoa p : dataResult) {
                    array[cont0] = p.getId() + ";";
                    array[cont0] += p.getNome() + ";";
                    array[cont0] += p.getData() + ";";
                    array[cont0] += p.getDengueOnibus() + "\n";

                    cont0++;
                }

                output.writeChars("ID;Nome;Data de Nascimento;Data da Dengue\n");

                for (int i = 0; i < array.length; i++) {
                    output.writeChars(array[i]);
                }
                break;
        }
    }

    //Metodos para manipulação de dados
    public static LinkedList[] compareDatabase(LinkedList<Pessoa> arquivo1, LinkedList<Pessoa> arquivo2, DataOutputStream output, int item) throws IOException {
        LinkedList<Pessoa> dataResult = new LinkedList<Pessoa>();
        LinkedList<Pessoa> filterResult = new LinkedList<Pessoa>();

        for (Pessoa p1 : arquivo2) {
            Pessoa maiorScoreId = null;

            double maxScore = 0;

            for (Pessoa p2 : arquivo1) {

                double score = distance(p1.getBloco(), p2.getBloco());

                if (score > maxScore) {
                    maxScore = score;
                    maiorScoreId = p2;
                }
            }

            p1.setScore(maxScore);
            p1.setIdExterno(maiorScoreId);

            if (item == 6) {
                if (p1.getScore() >= 0.8) {
                    Pessoa t = new Pessoa();

                    t.setId(p1.getId());
                    t.setNome(p1.getNome());
                    t.setPai(p1.getPai());
                    t.setMae(p1.getMae());
                    t.setSexo(p1.getSexo());
                    t.setData(p1.getData());
                    t.setDengueOnibus(p1.getIdExterno().getDengueOnibus());
                    t.setOnibus(p1.getDengueOnibus());

                    dataResult.add(t);
                }

                if (p1.getScore() < 0.8) {
                    Pessoa t = new Pessoa();

                    t.setId(p1.getId());
                    t.setNome(p1.getNome());
                    t.setData(p1.getData());
                    t.setDengueOnibus(p1.getDengueOnibus());

                    filterResult.add(t);
                }
            }
        }

        for (Pessoa p : arquivo2) {
            switch (item) {
                case 1:
                case 3:
                case 9:
                    if (p.getScore() < 0.8) {
                        Pessoa t = new Pessoa();

                        t.setId(p.getId());
                        t.setNome(p.getNome());
                        t.setPai(p.getPai());
                        t.setMae(p.getMae());
                        t.setSexo(p.getSexo());
                        t.setData(p.getData());
                        t.setDengueOnibus(p.getDengueOnibus());

                        dataResult.add(t);
                    }

                    if (p.getScore() >= 0.8) {
                        Pessoa t = new Pessoa();

                        t.setId(p.getId());
                        t.setNome(p.getNome());
                        t.setData(p.getData());
                        t.setDengueOnibus(p.getDengueOnibus());

                        filterResult.add(t);
                    }
                    break;
                case 2:
                case 4:
                case 5:
                case 8:
                    if (p.getScore() >= 0.8) {
                        Pessoa t = new Pessoa();

                        t.setId(p.getId());
                        t.setNome(p.getNome());
                        t.setPai(p.getPai());
                        t.setMae(p.getMae());
                        t.setSexo(p.getSexo());
                        t.setData(p.getData());
                        t.setDengueOnibus(p.getDengueOnibus());

                        dataResult.add(t);
                    }

                    if (p.getScore() < 0.8) {
                        Pessoa t = new Pessoa();

                        t.setId(p.getId());
                        t.setNome(p.getNome());
                        t.setData(p.getData());
                        t.setDengueOnibus(p.getDengueOnibus());

                        filterResult.add(t);
                    }
                    break;
            }
        }

        LinkedList resultado[] = new LinkedList[2];

        resultado[0] = dataResult;
        resultado[1] = filterResult;

        return resultado;
    }

    public static LinkedList[] compareDatabase(LinkedList<Pessoa> arquivo1, LinkedList<Pessoa> arquivo2, LinkedList<Pessoa> arquivo3, DataOutputStream output, int item) {
        LinkedList<Pessoa> dataResult = new LinkedList<Pessoa>();
        LinkedList<Pessoa> filterResult = new LinkedList<Pessoa>();

        if (item == 7) {
            for (Pessoa p1 : arquivo2) {
                Pessoa maiorScoreId = null;

                double maxScore = 0;

                for (Pessoa p2 : arquivo1) {

                    double score = distance(p1.getBloco(), p2.getBloco());

                    if (score > maxScore) {
                        maxScore = score;
                        maiorScoreId = p2;
                    }
                }

                p1.setScore(maxScore);
                p1.setIdExterno(maiorScoreId);
            }

            for (Pessoa p1 : arquivo2) {

                double maxScore = 0;

                if (p1.getScore() >= 0.8) {
                    for (Pessoa p2 : arquivo3) {

                        double score = distance(p1.getBloco(), p2.getBloco());

                        if (score > maxScore) {
                            maxScore = score;
                        }
                    }

                    p1.setScore1(maxScore);
                }

                if (p1.getScore() >= 0.8 && p1.getScore1() >= 0.8) {
                    Pessoa t = new Pessoa();

                    t.setId(p1.getId());
                    t.setNome(p1.getNome());
                    t.setPai(p1.getPai());
                    t.setMae(p1.getMae());
                    t.setSexo(p1.getSexo());
                    t.setData(p1.getData());
                    t.setDengueOnibus(p1.getIdExterno().getDengueOnibus());
                    t.setOnibus(p1.getDengueOnibus());

                    dataResult.add(t);
                }
            }
        } else if (item
                == 10) {
            dataResult = (LinkedList<Pessoa>) arquivo2.clone();

            for (Pessoa p1 : arquivo2) {

                double maxScore = 0;

                for (Pessoa p2 : arquivo1) {

                    double score = distance(p1.getBloco(), p2.getBloco());

                    if (score > maxScore) {
                        maxScore = score;
                        p1.setScore(maxScore);
                    }
                }

                if (maxScore >= 0.8) {
                    filterResult.add(p1);
                    dataResult.remove(p1);
                }
            }

            for (Pessoa p1 : arquivo2) {

                double maxScore = 0;

                for (Pessoa p2 : arquivo3) {

                    double score = distance(p1.getBloco(), p2.getBloco());

                    if (score > maxScore) {
                        maxScore = score;
                        p1.setScore(maxScore);
                    }
                }

                if (maxScore >= 0.8) {
                    if (!filterResult.contains(p1)) {
                        filterResult.add(p1);
                    }

                    dataResult.remove(p1);
                }
            }
        }

        LinkedList resultado[] = new LinkedList[3];

        resultado[0] = dataResult;
        resultado[1] = filterResult;

        return resultado;
    }

//Distância de Jaro-Winkler
    public static double distance(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();

        if (s_len == 0 && t_len == 0) {
            return 1;
        }

        int match_distance = Integer.max(s_len, t_len) / 2 - 1;

        boolean[] s_matches = new boolean[s_len];
        boolean[] t_matches = new boolean[t_len];

        int matches = 0;
        int transpositions = 0;

        for (int i = 0; i < s_len; i++) {
            int start = Integer.max(0, i - match_distance);
            int end = Integer.min(i + match_distance + 1, t_len);

            for (int j = start; j < end; j++) {
                if (t_matches[j]) {
                    continue;
                }
                if (s.charAt(i) != t.charAt(j)) {
                    continue;
                }
                s_matches[i] = true;
                t_matches[j] = true;
                matches++;
                break;
            }
        }

        if (matches == 0) {
            return 0;
        }

        int k = 0;
        for (int i = 0; i < s_len; i++) {
            if (!s_matches[i]) {
                continue;
            }
            while (!t_matches[k]) {
                k++;
            }
            if (s.charAt(i) != t.charAt(k)) {
                transpositions++;
            }
            k++;
        }

        return (((double) matches / s_len) + ((double) matches / t_len)
                + (((double) matches - transpositions / 2.0) / matches)) / 3.0;
    }
}
