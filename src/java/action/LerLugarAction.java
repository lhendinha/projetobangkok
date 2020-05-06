package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Lugar;

public class LerLugarAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("lugares", Lugar.obterLugares());
            RequestDispatcher view = request.getRequestDispatcher(ArquivosJSP.getInstancia().getLerLugares());
            view.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e){
            e.printStackTrace();
        }
    }
    
}
