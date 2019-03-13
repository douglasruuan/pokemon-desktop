/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.PersonagemDAO;
import dao.PokemonDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.PokemonVO;

/**
 *
 * @author Douglas
 */
public class PokemonsServicos {
        //Metodo cadastrar
    public void cadastrarPokemon(PokemonVO sVO) throws SQLException {
        PokemonDAO sDAO = DAOFactory.getPokemonDAO();
        sDAO.cadastrarPokemon(sVO);
    }//fecha método

    //Método buscar
    public ArrayList<PokemonVO> buscarPokemons() throws SQLException {
        PokemonDAO sDAO = DAOFactory.getPokemonDAO();
        return sDAO.buscarPokemons();
    }//fecha método
     public void deletarPokemon(long id) throws SQLException {
        PokemonDAO pDAO = DAOFactory.getPokemonDAO();
        pDAO.deletarPokemon(id);
    }
    
}
