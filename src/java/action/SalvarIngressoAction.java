package action;

import controle.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Show;

public class SalvarIngressoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cliente = request.getParameter("cboCliente");
        String show = request.getParameter("cboShow");
        
        if (cliente.equals("") || show.equals("")){
            response.sendRedirect("erro.jsp");
        } else {
            try {
                Cliente clienteSalvar = Cliente.obterCliente(Integer.parseInt(cliente));
                Show showSalvar = Show.obterShow(Integer.parseInt(show));
                
                clienteSalvar.adicionarShow(showSalvar);
                
                request.setAttribute("cliente", clienteSalvar);
                RequestDispatcher view = request.getRequestDispatcher("/menssagemEmissaoIngresso.jsp");
                view.forward(request, response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(SalvarIngressoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
