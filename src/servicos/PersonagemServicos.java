package servicos;

import dao.DAOFactory;
import dao.PersonagemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.PersonagemVO;

/**
 *
 * @author Douglas
 */
public class PersonagemServicos {

    //Metodo cadastrar
    public void cadastrarPersonagem(PersonagemVO sVO) throws SQLException {
        PersonagemDAO sDAO = DAOFactory.getPersonagemDAO();
        sDAO.cadastrarPersonagem(sVO);
    }//fecha método

    public ArrayList<PersonagemVO> buscarPersonagem() throws SQLException {
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        return pDAO.buscarPersonagems();
    }//fecha método
 public void alterarPersonagem(PersonagemVO pVO) throws SQLException {
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        pDAO.alterarPersonagem(pVO);
    }//fecha método
  public ArrayList<PersonagemVO> filtrar(String query) throws SQLException {
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        return pDAO.filtrar(query);
    }//fecha método

    public void deletarPersonagem(long id) throws SQLException {
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        pDAO.deletarPersonagem(id);
    }
}
