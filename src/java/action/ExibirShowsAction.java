package action;

import controle.Action;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Show;

public class ExibirShowsAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo = request.getParameter("codigo");
        
        if (codigo.equals("")){
            response.sendRedirect("index.jsp");
        } else {
            try {
                Cliente cliente = Cliente.obterCliente(Integer.parseInt(codigo));
                Iterator listaShows = cliente.getShows().iterator();
                StringBuilder shows = new StringBuilder();
                
                while(listaShows.hasNext()){
                    Show showVez = (Show) listaShows.next();
                    shows.append(showVez.getDescricao()).append(" ;");
                }
                
                request.setAttribute("cliente", cliente);
                request.setAttribute("shows", shows.toString());
                RequestDispatcher view = request.getRequestDispatcher("/exibirShows.jsp");
                view.forward(request, response);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                ex.printStackTrace();
            }
            
            
        }
    }
    
}
