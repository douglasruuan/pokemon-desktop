package dao;

/**
 *
 * @author Douglas
 * @since 07/07/2018 - 3:46
 * @version 1.0 - Beta Carrero
 */
public class DAOFactory {
    
    private static final PersonagemDAO personagemDAO = new PersonagemDAO();
    private static final PokemonDAO pokemonDAO = new PokemonDAO();
    
    public static PersonagemDAO getPersonagemDAO(){
        return personagemDAO;
      }//fecha método
    
    public static PokemonDAO getPokemonDAO(){
        return pokemonDAO;
    }//Fecha Método
    
}
