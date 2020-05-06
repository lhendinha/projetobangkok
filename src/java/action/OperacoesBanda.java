package action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Banda;

public abstract class OperacoesBanda {

    protected abstract void realizarCUD(Banda banda)throws ClassNotFoundException, SQLException;
    
    public void realizarOperacao(HttpServletRequest request, HttpServletResponse response){
        String codigo = request.getParameter("txtCodigo");
        String nome = request.getParameter("txtNome");
        String genero = request.getParameter("txtGenero");
        String avaliacao = request.getParameter("txtAvaliacao");
        
        if(codigo.equals("") || nome.equals("") || genero.equals("")) {
            try {
                response.sendRedirect(ArquivosJSP.getInstancia().getSmsErro());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try{
                Banda banda = new Banda(Integer.parseInt(codigo), nome, genero, Float.parseFloat(avaliacao));
                realizarCUD(banda);
                response.sendRedirect(ArquivosJSP.getInstancia().getSmsSucesso());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
