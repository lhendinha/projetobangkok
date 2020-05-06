package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Show;

public class LerShowAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("shows", Show.obterShows());
            RequestDispatcher view = request.getRequestDispatcher(ArquivosJSP.getInstancia().getLerShows());
            view.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e){
            e.printStackTrace();
        }
    }
    
}
