package modelo;

import java.util.ArrayList;

/**
 *
 * @author Douglas
 * @since 07/07/2018 - 3:46
 * @version 1.0 - Beta Carrero
 */
public class PokemonVO {

    private long idPokemon;
    private String pokemon;
    private String tipoPokemon;
    private int lvlPokemon;
    private String pokebolaUsada;
    private String pedraPokemon;

    private PokemonVO p;
    

    public PokemonVO() {
    }

    public PokemonVO(long idPokemon, String pokemon, String tipoPokemon, int lvlPokemon, String pokebolaUsada, String pedraPokemon, PokemonVO p) {
        this.idPokemon = idPokemon;
        this.pokemon = pokemon;
        this.tipoPokemon = tipoPokemon;
        this.lvlPokemon = lvlPokemon;
        this.pokebolaUsada = pokebolaUsada;
        this.pedraPokemon = pedraPokemon;
        this.p = p;
    }

    public long getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(long idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(String tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public int getLvlPokemon() {
        return lvlPokemon;
    }

    public void setLvlPokemon(int lvlPokemon) {
        this.lvlPokemon = lvlPokemon;
    }

    public String getPokebolaUsada() {
        return pokebolaUsada;
    }

    public void setPokebolaUsada(String pokebolaUsada) {
        this.pokebolaUsada = pokebolaUsada;
    }

    public String getPedraPokemon() {
        return pedraPokemon;
    }

    public void setPedraPokemon(String pedraPokemon) {
        this.pedraPokemon = pedraPokemon;
    }

    public PokemonVO getP() {
        return p;
    }

    public void setP(PokemonVO p) {
        this.p = p;
    }


    @Override
    public String toString() {
        return "idPokemon=" + idPokemon
                + ", pokemon=" + pokemon
                + ", tipoPokemon=" + tipoPokemon
                + ", lvlPokemon=" + lvlPokemon
                + ", pokebolaUsada=" + pokebolaUsada
                + ", pedraPokemon=" + pedraPokemon;
    }


   

   

}//fecha classe
