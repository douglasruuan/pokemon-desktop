package modelo;

import java.util.ArrayList;

/**
 *
 * @author Douglas
 * @since 07/07/2018 - 3:46
 * @version 1.0 - Beta Carrero
 */
public class PersonagemVO {

    private long idPersonagem;
    private String nome;
    private String sexo;
    private int idade;
    private String cidade;
    private String insignia;
    private int pokemonsCapturado;
    private String saffari;
    private ArrayList<String> Personagem;
    

    public PersonagemVO() {
    }

    /**
     *
     * @param idPersonagem
     * @param nome
     * @param sexo
     * @param idade
     * @param cidade
     * @param insignia
     * @param pokemonsCapturado
     * @param saffari
     */
    public PersonagemVO(long idPersonagem, String nome, String sexo, int idade, String cidade, String insignia, int pokemonsCapturado, String saffari) {
        this.idPersonagem = idPersonagem;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cidade = cidade;
        this.insignia = insignia;
        this.pokemonsCapturado = pokemonsCapturado;
        this.saffari = saffari;
    }

    public long getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(long idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getInsignia() {
        return insignia;
    }

    public void setInsignia(String insignia) {
        this.insignia = insignia;
    }

    public int getPokemonsCapturado() {
        return pokemonsCapturado;
    }

    public void setPokemonsCapturado(int pokemonsCapturado) {
        this.pokemonsCapturado = pokemonsCapturado;
    }

    public String getSaffari() {
        return saffari;
    }

    public void setSaffari(String saffari) {
        this.saffari = saffari;
    }

    public ArrayList<String> getPersonagem() {
        return Personagem;
    }

    public void setPersonagem(ArrayList<String> Personagem) {
        this.Personagem = Personagem;
    }   
    

    @Override
    public String toString() {
        return "idPersonagem=" + idPersonagem
                + ", nome=" + nome
                + ", sexo=" + sexo
                + ", idade=" + idade
                + ", cidade=" + cidade
                + ", insignia=" + insignia
                + ", pokemonsCapturado=" + pokemonsCapturado
                + ", saffari=" + saffari;
    }

}//fecha classe
