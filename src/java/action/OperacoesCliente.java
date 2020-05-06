package action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

public abstract class OperacoesCliente {
    
    protected abstract void realizarCUD(Cliente cliente)throws ClassNotFoundException, SQLException;
    
    public void realizarOperacao(HttpServletRequest request, HttpServletResponse response){
        String codigo = request.getParameter("txtCodigo");
        String nome = request.getParameter("txtNome");
        String tipo = request.getParameter("cboCliente");
        
        if(codigo.equals("") || nome.equals("") || tipo.equals("")){
            try {
                response.sendRedirect(ArquivosJSP.getInstancia().getSmsErro());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Cliente cliente = new Cliente(
                        Integer.parseInt(codigo), 
                        nome,
                        tipo                
                );
                
                realizarCUD(cliente);
                response.sendRedirect(ArquivosJSP.getInstancia().getSmsSucesso());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
