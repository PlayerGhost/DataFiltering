package datafiltering;

public class Pessoa {

    private String id;
    private String nome;
    private String pai;
    private String mae;
    private String sexo;
    private double score;
    private double score1;
    private Pessoa idExterno;
    private String data;
    private String dengueOnibus;
    private String onibus;

    public Pessoa() {

    }

    public Pessoa(String id, String nome, String data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
    }

    public Pessoa(String id, String nome, String data, String dengueOnibus) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.dengueOnibus = dengueOnibus;
    }

    public Pessoa(String id, String nome, String data, String dengueOnibus, String onibus) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.dengueOnibus = dengueOnibus;
        this.onibus = onibus;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public String getOnibus() {
        return onibus;
    }

    public void setOnibus(String onibus) {
        this.onibus = onibus;
    }

    public String getDengueOnibus() {
        return dengueOnibus;
    }

    public void setDengueOnibus(String dataDengue) {
        this.dengueOnibus = dataDengue;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase();
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Pessoa getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(Pessoa idExterno) {
        this.idExterno = idExterno;
    }

    public String getBloco() {
        return nome + pai + mae + sexo;
    }
}
