package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Banda;

public abstract class CarregarDadosBanda {
    
    private String acao;

    protected abstract String getAcao();
    
    public void carregar(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("action", getAcao());
            Banda banda = Banda.obterBanda(Integer.parseInt(request.getParameter("codigo")));
            request.setAttribute("banda", banda);
            RequestDispatcher view = request.getRequestDispatcher(ArquivosJSP.getInstancia().getManterBanda());
            view.forward(request, response);
        } catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
