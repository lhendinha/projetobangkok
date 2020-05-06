package action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Banda;
import modelo.Lugar;
import modelo.Show;

public abstract class OperacoesShow {

    protected abstract void realizarCUD(Show show)throws ClassNotFoundException, SQLException;
    
    public void realizarOperacao(HttpServletRequest request, HttpServletResponse response){
        String codigo = request.getParameter("txtCodigo");
        String descricao = request.getParameter("txtDescricao");
        String dia = request.getParameter("txtDia");
        String hora = request.getParameter("txtHora");
        String codigoBanda = request.getParameter("cboBandas");
        int codigoLugar = Integer.parseInt(request.getParameter("cboLugares"));
        
        if(codigo.equals("") || descricao.equals("") || dia.equals("") || hora.equals("") || codigoBanda.equals("")){
            try {
                response.sendRedirect(ArquivosJSP.getInstancia().getSmsErro());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Banda banda = Banda.obterBanda(Integer.parseInt(codigoBanda));
                Lugar lugar = null;
                
                if(codigoLugar != 0){
                    lugar = Lugar.obterLugar(codigoLugar);
                }                
                
                Show show = new Show(
                        Integer.parseInt(codigo), 
                        descricao, 
                        dia, 
                        hora, 
                        banda, 
                        lugar);
                realizarCUD(show);
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
