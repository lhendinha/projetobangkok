package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

public abstract class CarregarDadosCliente {
    
    private String acao;

    protected abstract String getAcao();
    
    public void carregar(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("action", getAcao());
            Cliente clientePesquisado = Cliente.obterCliente(Integer.parseInt(request.getParameter("codigo")));
            request.setAttribute("cliente", clientePesquisado);
            RequestDispatcher view = request.getRequestDispatcher(ArquivosJSP.getInstancia().getManterCliente());
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
