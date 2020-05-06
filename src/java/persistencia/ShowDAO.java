package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Show;
import modelo.ShowEstado;
import modelo.ShowEstadoFactory;


public class ShowDAO {

    private static ShowDAO instancia = new ShowDAO();

    private ShowDAO() {}

    public static ShowDAO getInstancia() {
        return instancia;
    }
    
    /*Métodos de inclusão, exclusão e alteração*/
    
    public void salvar(Show show) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("insert into evento (codigo, descricao, dia, hora, estado, banda, lugar) values (?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, show.getCodigo());
            st.setString(2, show.getDescricao());
            st.setString(3, show.getDia());
            st.setString(4, show.getHora());
            st.setString(5, "ShowEstado" + show.getEstado().getEstado());
            st.setInt(6, show.getBanda().getCodigo());
            if (show.getLugar() == null){
                st.setNull(7, Types.NULL);
            } else {
                st.setInt(7, show.getLugar().getCodigo());
            }
            st.execute();
        }  catch(SQLException e) {
                throw e;
        } finally {
            fecharConexoes (conn, st);
        }
    }
    
    public void alterar(Show show) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("update evento set descricao=? , dia=? , hora=?, estado=?, banda=?, lugar=? where codigo=?");
            st.setString(1, show.getDescricao());
            st.setString(2, show.getDia());
            st.setString(3, show.getHora());
            st.setString(4, "ShowEstado" + show.getEstado().getEstado());
            st.setInt(5, show.getBanda().getCodigo());
            if (show.getLugar() == null){
                st.setNull(6, Types.NULL);
            } else {
                st.setInt(6, show.getLugar().getCodigo());
            }
            st.setInt(7, show.getCodigo());
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexoes(conn, st);
        }
    }
    
    public void excluir(Show show) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("delete from evento where codigo=?");
            st.setInt(1, show.getCodigo());
            st.execute();
        }  catch(SQLException e) {
                throw e;
            } finally {
            fecharConexoes (conn, st);
        }
    }
    
    /*Métodos de busca*/
    
    public Show obterShow(int codigoShow) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        Show showResposta = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from evento where codigo=?");
            st.setInt(1, codigoShow);
            ResultSet respostaConsulta = st.executeQuery();
            
            respostaConsulta.first();
            
            showResposta = new Show(respostaConsulta.getInt("codigo"),
                    respostaConsulta.getString("descricao"),
                    respostaConsulta.getString("dia"),
                    respostaConsulta.getString("hora"),
                    null,
                    null);
            
            ShowEstado estadoShow = ShowEstadoFactory.create(respostaConsulta.getString("estado"));
            
            showResposta.setEstado((ShowEstado) estadoShow);
            showResposta.setCodigoBanda(respostaConsulta.getInt("banda"));
            showResposta.setCodigoLugar(respostaConsulta.getInt("lugar"));
        }  catch(SQLException e) {
                e.printStackTrace();
        } finally {
            fecharConexoes(conn, st);
        }
        
        return showResposta;
    }
    
    public List<Show> obterShows() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement st = null;
        List<Show> shows = new ArrayList<>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from evento");
            ResultSet respostaConsulta = st.executeQuery();
            
            while (respostaConsulta.next()) {                
                Show show = new Show(respostaConsulta.getInt("codigo"),
                    respostaConsulta.getString("descricao"),
                    respostaConsulta.getString("dia"),
                    respostaConsulta.getString("hora"),
                    null,
                    null);
            
                ShowEstado estadoShow = ShowEstadoFactory.create(respostaConsulta.getString("estado"));
                
                show.setEstado((ShowEstado) estadoShow);
                show.setCodigoBanda(respostaConsulta.getInt("banda"));
                show.setCodigoLugar(respostaConsulta.getInt("lugar"));
            
            shows.add(show);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexoes(conn, st);
        }
        
        return shows;
    }

    public void obterClientesShow(Show show) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from ingresso where codigoEvento=?");
            st.setInt(1, show.getCodigo());
            ResultSet respostaConsulta = st.executeQuery();
            
            while(respostaConsulta.next()){
                Cliente cliente = Cliente.obterCliente(respostaConsulta.getInt("codigoCliente"));
                cliente.adicionarShowBusca(show);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexoes(conn, st);
        }
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