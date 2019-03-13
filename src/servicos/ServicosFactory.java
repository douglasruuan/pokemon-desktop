/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author Douglas
 */
public class ServicosFactory {
        
    private static final PersonagemServicos personagemServicos=new PersonagemServicos();
    private static final PokemonsServicos pokemonsServicos=new PokemonsServicos();
    
    public static PersonagemServicos getPersonagemServicos(){
        return personagemServicos;
    }//fecha método
    
    public static PokemonsServicos getPokemonsServicos(){
        return pokemonsServicos;
    }//fecha método
    
}
