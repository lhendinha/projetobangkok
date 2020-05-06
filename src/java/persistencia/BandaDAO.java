package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Banda;


public class BandaDAO {

    private static BandaDAO instancia = new BandaDAO();

    private BandaDAO() {}
    
    public static BandaDAO getInstancia() {
        return instancia;
    }

    /*Métodos de inclusão, exclusão e alteração*/
    
    public void salvar(Banda banda) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("insert into banda (codigo, nome, genero, avaliacao) values (?, ?, ?, ?)");
            st.setInt(1, banda.getCodigo());
            st.setString(2, banda.getNome());
            st.setString(3, banda.getGenero());
            st.setString(4, banda.getAvaliacao());
            st.execute();
        }  catch(SQLException e) {
                throw e;
            } finally {
            fecharConexoes (conn, st);
        }
    }
    
    public void alterar(Banda banda) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("update banda set nome=? , genero=?, avaliacao=? where codigo=?");
            st.setString(1, banda.getNome());
            st.setString(2, banda.getAvaliacao());
            st.setString(3, banda.getGenero());
            st.setInt(3, banda.getCodigo());
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexoes(conn, st);
        }
    }
    
    public void excluir(Banda banda) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("delete from banda where codigo=?");
            st.setInt(1, banda.getCodigo());
            st.execute();
        }  catch(SQLException e) {
                throw e;
            } finally {
            fecharConexoes (conn, st);
        }
    }
    
    /*Métodos de busca*/
    
    public Banda obterBanda(int codigoBanda) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        Banda bandaResposta = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from banda where codigo=?");
            st.setInt(1, codigoBanda);
            ResultSet repostaConsulta = st.executeQuery();
            
            repostaConsulta.first();
            
            bandaResposta = new Banda(repostaConsulta.getInt("codigo"), repostaConsulta.getString("nome"), repostaConsulta.getString("genero"), repostaConsulta.getFloat("avaliacao"));
        }  catch(SQLException e) {
                e.printStackTrace();
            } finally {
            fecharConexoes(conn, st);
        }
        
        return bandaResposta;
    }
    
    public List<Banda> obterBandas() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement st = null;
        List<Banda> bandas = new ArrayList<>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from banda");
            ResultSet respostaConsulta = st.executeQuery();
            
            while (respostaConsulta.next()) {                
                Banda contato = new Banda(respostaConsulta.getInt("codigo"), respostaConsulta.getString("nome"),respostaConsulta.getString("genero"), respostaConsulta.getFloat("avaliacao"));
                bandas.add(contato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexoes(conn, st);
        }
        
        return bandas;
    }
    
    /*Métodos para fechar a conexão com o banco de dados*/
    
    public void fecharConexoes (Connection conn, PreparedStatement st){
        try {
            if(st != null) st.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}