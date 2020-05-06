package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Show;

public class PrepararSalvarIngressoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("action", "Salvar");
        try {
            request.setAttribute("clientes", Cliente.obterClientes());
            request.setAttribute("shows", Show.obterShows());
            RequestDispatcher view = request.getRequestDispatcher("/manterIngresso.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();;
        }
    }
    
}
