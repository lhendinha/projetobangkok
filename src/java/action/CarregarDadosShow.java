package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Banda;
import modelo.Lugar;
import modelo.Show;

public abstract class CarregarDadosShow {

    private String acao;

    protected abstract String getAcao();
    
    public void carregar(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("action", getAcao());
            request.setAttribute("bandas", Banda.obterBandas());
            request.setAttribute("lugares", Lugar.obterLugares());
            request.setAttribute("show", Show.obterShow(Integer.parseInt(request.getParameter("codigo"))));
            RequestDispatcher view = request.getRequestDispatcher(ArquivosJSP.getInstancia().getManterShow());
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
}