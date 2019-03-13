package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.PokemonVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author Douglas
 * @since 07/07/2018 - 3:46
 * @version 1.0 - Beta Carrero
 */
public class PokemonDAO {

    public void cadastrarPokemon(PokemonVO sVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;

            sql = "insert into pokemon(idpokemon, pokemon, lvlPokemon, pokebolaUsada, tipoPokemon, pedra)"
                    + "values(null,"
                    + "'" + sVO.getPokemon() + "'" + ","
                    + "" + "" + sVO.getLvlPokemon()+ "" + ","
                    + "" + "'" + sVO.getPokebolaUsada() + "'" + ","
                    + "" + "'" + sVO.getTipoPokemon() + "'" + ","
                    + "" + "'" + sVO.getPedraPokemon() + "')";

            PreparedStatement pstmt = con.prepareStatement(sql);

            //Executando o sql
            pstmt.execute();

        } catch (SQLException se) {
            throw new SQLException("Erro ao cadastrar pokemon! " + se.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método cadastrarPersonagem

    public ArrayList<PokemonVO> buscarPokemons() throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConexaoBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //Criando variável sql vazia
            String sql;

            //Montando o sql
            sql = "select * from pokemon";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<PokemonVO> Apokemon = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                PokemonVO pVO = new PokemonVO();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                pVO.setIdPokemon(rs.getLong("idpokemon"));
                pVO.setPokemon(rs.getString("pokemon"));
                pVO.setLvlPokemon(rs.getInt("lvlPokemon"));
                pVO.setPokebolaUsada(rs.getString("pokebolaUsada"));
                pVO.setTipoPokemon(rs.getString("tipoPokemon"));
                pVO.setPedraPokemon(rs.getString("pedra"));

                /* Inserindo o objeto pVO no ArrayList */
                Apokemon.add(pVO);

            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return Apokemon;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
    }//fecha método buscarProdutos
    public void deletarPokemon(long id) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql="delete from pokemon where idpokemon="+id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar! "+e.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
     }//fecha deletarProduto

   
}//fecha classe

