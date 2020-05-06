package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import modelo.Cliente;
import modelo.Show;

public class ClienteDAO {
    
    private static ClienteDAO instancia = new ClienteDAO();

    private ClienteDAO() {};

    public static ClienteDAO getInstancia() {
        return instancia;
    }
    
    /*Métodos GET e SET*/
    
    public void salvar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("insert into cliente (codigo, nome, tipo) values (?, ?, ?)");
            st.setInt(1, cliente.getCodigo());
            st.setString(2, cliente.getNome());
            st.setString(3, cliente.getTipo().getTipo());
            st.execute();
        }  catch(SQLException e) {
                throw e;
        } finally {
            fecharConexoes (conn, st);
        }
    }
    
    public void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("update cliente set nome=?, tipo=? where codigo=?");
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getTipo().getTipo());
            st.setInt(3, cliente.getCodigo());
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexoes(conn, st);
        }
    }
    
    public void excluir(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("delete from cliente where codigo=?");
            st.setInt(1, cliente.getCodigo());
            st.execute();
        }  catch(SQLException e) {
                throw e;
            } finally {
            fecharConexoes (conn, st);
        }
    }
    
    /*Métodos de busca*/
    
    public Cliente obterCliente(int codigoCliente) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement st = null;
        Cliente clienteResposta = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("select * from cliente where codigo=?");
            st.setInt(1, codigoCliente);
            ResultSet respostaConsulta = st.executeQuery();
            
            respostaConsulta.first();
            
            clienteResposta = new Cliente(
                    respostaConsulta.getInt("codigo"),
                    respostaConsulta.getString("nome"),
                    respostaConsulta.getString("tipo")
            );
            
            st = conn.prepareStatement("select * from ingresso where codigoCliente=?");
            st.setInt(1, clienteResposta.getCodigo());
            respostaConsulta = st.executeQuery();
            
            if(respostaConsulta.next()){
                List<Observable> shows = new ArrayList<>();
                
                do {                    
                    shows.add(Show.obterShow(respostaConsulta.getInt("codigoEvento")));
                } while (respostaConsulta.next());
                
                clienteResposta.setShows(shows);
            }
            
        }  catch(SQLException e) {
                e.printStackTrace();
        } finally {
            fecharConexoes(conn, st);
        }
        
        return clienteResposta;
    }
    
    public List<Cliente> obterClientes() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement st1 = null;
        PreparedStatement st2 = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st1 = conn.prepareStatement("select * from cliente");
            ResultSet respostaConsulta = st1.executeQuery();
            
            while (respostaConsulta.next()) {
                Cliente cliente = new Cliente(
                        respostaConsulta.getInt("codigo"),
                        respostaConsulta.getString("nome"),
                        respostaConsulta.getString("tipo")
                );
                
                st2 = conn.prepareStatement("select * from ingresso where codigoCliente=?");
                st2.setInt(1, cliente.getCodigo());
                ResultSet respostaConsulta2 = st2.executeQuery();

                if(respostaConsulta2.next()){
                    List<Observable> shows = new ArrayList<>();

                    do {                    
                        shows.add(Show.obterShow(respostaConsulta2.getInt("codigoEvento")));
                    } while (respostaConsulta2.next());

                    cliente.setShows(shows);
                }
            
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexoes(conn, st1);
        }
        
        return clientes;
    }
    
    public void adicionarShow(Cliente cliente, Show show)throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("insert into ingresso (codigoEvento, codigoCliente) values (?, ?)");
            st.setInt(1, show.getCodigo());
            st.setInt(2, cliente.getCodigo());
            st.execute();
        }  catch(SQLException e) {
                throw e;
        } finally {
            fecharConexoes (conn, st);
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
