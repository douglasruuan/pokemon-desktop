package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.PersonagemVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author Douglas
 * @since 07/07/2018 - 3:46
 * @version 1.0 - Beta Carrero
 */
public class PersonagemDAO {

    public void cadastrarPersonagem(PersonagemVO sVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;

            sql = "insert into personagem(idpersonagem, nome, sexo, idade, cidade, insignias,pokemonscapt,acessoSaffari)"
                    + "values(null,"
                    + "'" + sVO.getNome() + "'" + ","
                    + "'" + sVO.getSexo() + "'" + ","
                    + "" + sVO.getIdade() + "" + ","
                    + "'" + sVO.getCidade() + "'" + ","
                    + "'" + sVO.getInsignia() + "'" + ","
                    + "'" + sVO.getPokemonsCapturado() + "',"
                    + "'" + sVO.getSaffari() + "')";

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException se) {
            throw new SQLException("Erro ao inserir dados no Banco de Dados! " + se.getMessage());
        } finally {
            //Encerrando as conexões
            stat.close();
            con.close();
        }//fecha finally
    }//fecha método cadastrarPersonagem

    public ArrayList<PersonagemVO> buscarPersonagems() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from personagem";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            ArrayList<PersonagemVO> prod = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                PersonagemVO p = new PersonagemVO();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                p.setIdPersonagem(rs.getLong("idpersonagem"));
                p.setNome(rs.getString("nome"));
                p.setSexo(rs.getString("sexo"));
                p.setIdade(rs.getInt("idade"));
                p.setCidade(rs.getString("cidade"));
                p.setInsignia(rs.getString("insignias"));
                p.setPokemonsCapturado(rs.getInt("pokemonscapt"));
                p.setSaffari(rs.getString("acessoSaffari"));

                /* Inserindo o objeto pVO no ArrayList */
                prod.add(p);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar personagems! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void alterarPersonagem(PersonagemVO pVO) throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConexaoBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //String que receberá instrução SQL
            String sql;

            sql = "update personagem set nome='" + pVO.getNome()
                    + "', sexo=" + pVO.getSexo()
                    + ", idade=" + pVO.getIdade()
                    + ", cidade=" + pVO.getCidade()
                    + ", insignias=" + pVO.getInsignia()
                    + ", pokemonscapt=" + pVO.getPokemonsCapturado()
                    + ", acessoSaffari=" + pVO.getSaffari()
                    + " where idpersonagem = " + pVO.getIdPersonagem();

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir personagem!");
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public ArrayList<PersonagemVO> filtrar(String query) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from personagem " + query;

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<PersonagemVO> prod = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                PersonagemVO p = new PersonagemVO();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                p.setIdPersonagem(rs.getLong("idpersonagem"));
                p.setNome(rs.getString("nome"));
                p.setSexo(rs.getString("sexo"));
                p.setIdade(rs.getInt("idade"));
                p.setCidade(rs.getString("cidade"));
                p.setInsignia(rs.getString("insignias"));
                p.setPokemonsCapturado(rs.getInt("pokemonscapt"));
                p.setSaffari(rs.getString("acessoSaffari"));

                /* Inserindo o objeto pVO no ArrayList */
                prod.add(p);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar personagem! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método
    public void deletarPersonagem(long id) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql="delete from personagem where idpersonagem="+id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar! "+e.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
     }//fecha deletarProduto

}
