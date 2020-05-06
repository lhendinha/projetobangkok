package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Lugar;


public class LugarDAO {

    private static LugarDAO instancia = new LugarDAO();

    private LugarDAO() {}

    public static LugarDAO getInstancia() {
        return instancia;
    } 
    
    /*Métodos de inclusão, exclusão e alteração*/
    
    public void salvar(Lugar lugar) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("insert into lugar (codigo, nome, lotacao, logradouro, numero, complemento, bairro, cidade, estado, cep) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, lugar.getCodigo());
            st.setString(2, lugar.getNome());
            st.setInt(3, lugar.getLotacao());
            st.setString(4, lugar.getLogradouro());
            st.setString(5, lugar.getNumero());
            st.setString(6, lugar.getComplemento());
            st.setString(7, lugar.getBairro());
            st.setString(8, lugar.getCidade());
            st.setString(9, lugar.getEstado());
            st.setString(10, lugar.getCep());
            st.execute();
        }  catch(SQLException e) {
                throw e;
            } finally {
            fecharConexoes (conn, st);
        }
    }
    
    public void alterar(Lugar lugar) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("update lugar set nome=? , lotacao=?, logradouro=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, cep=? where codigo=?");
            st.setString(1, lugar.getNome());
            st.setInt(2, lugar.getLotacao());
            st.setString(3, lugar.getLogradouro());
            st.setString(4, lugar.getNumero());
            st.setString(5, lugar.getComplemento());
            st.setString(6, lugar.getBairro());
            st.setString(7, lugar.getCidade());
            st.setString(8, lugar.getEstado());
            st.setString(9, lugar.getCep());
            st.setInt(10, lugar.getCodigo());
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexoes(conn, st);
        }
    }
    
    public void excluir(Lugar lugar) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("delete from lugar where codigo=?");
            st.setInt(1, lugar.getCodigo());
            st.execute();
        }  catch(SQLException e) {
                throw e;
            } finally {
            fecharConexoes (conn, st);
        }
    }
    
    /*Métodos de busca*/
    
    public Lugar obterLugar(int codigoLugar) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        Lugar lugarResposta = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from lugar where codigo=?");
            st.setInt(1, codigoLugar);
            ResultSet respostaConsulta = st.executeQuery();
            
            respostaConsulta.first();
            
            lugarResposta = new Lugar(respostaConsulta.getInt("codigo"),
                    respostaConsulta.getString("nome"),
                    respostaConsulta.getInt("lotacao"),
                    respostaConsulta.getString("logradouro"),
                    respostaConsulta.getString("numero"),
                    respostaConsulta.getString("complemento"),
                    respostaConsulta.getString("bairro"),
                    respostaConsulta.getString("cidade"),
                    respostaConsulta.getString("estado"),
                    respostaConsulta.getString("cep"));
        }  catch(SQLException e) {
                e.printStackTrace();
            } finally {
            fecharConexoes(conn, st);
        }
        
        return lugarResposta;
    }
    
    public List<Lugar> obterLugares() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement st = null;
        List<Lugar> lugares = new ArrayList<>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from lugar");
            ResultSet respostaConsulta = st.executeQuery();
            
            while (respostaConsulta.next()) {                
                Lugar lugar = new Lugar(respostaConsulta.getInt("codigo"),
                    respostaConsulta.getString("nome"),
                    respostaConsulta.getInt("lotacao"),
                    respostaConsulta.getString("logradouro"),
                    respostaConsulta.getString("numero"),
                    respostaConsulta.getString("complemento"),
                    respostaConsulta.getString("bairro"),
                    respostaConsulta.getString("cidade"),
                    respostaConsulta.getString("estado"),
                    respostaConsulta.getString("cep"));
            
            lugares.add(lugar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexoes(conn, st);
        }
        
        return lugares;
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
