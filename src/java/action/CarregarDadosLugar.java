package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Lugar;

public abstract class CarregarDadosLugar {
    
    private String acao;

    protected abstract String getAcao();
    
    public void carregar(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("action", getAcao());
            Lugar lugar = Lugar.obterLugar(Integer.parseInt(request.getParameter("codigo")));
            request.setAttribute("lugar", lugar);
            RequestDispatcher view = request.getRequestDispatcher(ArquivosJSP.getInstancia().getManterLugar());
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
