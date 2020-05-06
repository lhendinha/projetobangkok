package action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Lugar;

public abstract class OperacoesLugar {
    
    protected abstract void realizarCUD(Lugar lugar)throws ClassNotFoundException, SQLException;
    
    public void realizarOperacao(HttpServletRequest request, HttpServletResponse response){
        String codigo = request.getParameter("txtCodigo");
        String nome = request.getParameter("txtNome");
        String lotacao = request.getParameter("txtLotacao");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumero");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("cboEstado");
        String cep = request.getParameter("txtCep");
        
        if(codigo.equals("") || nome.equals("") || lotacao.equals("") || logradouro.equals("") || numero.equals("") || complemento.equals("") || bairro.equals("") || cidade.equals("") || estado.equals("") || cep.equals("")) {
            try {
                response.sendRedirect(ArquivosJSP.getInstancia().getSmsErro());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try{
                Lugar lugar = new Lugar(
                        Integer.parseInt(codigo),
                        nome, 
                        Integer.parseInt(lotacao),
                        logradouro,
                        numero,
                        complemento,
                        bairro,
                        cidade,
                        estado,
                        cep);
                
                realizarCUD(lugar);
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
