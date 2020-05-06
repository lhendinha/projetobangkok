package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Relatorio;
import modelo.RelatorioFactory;

public class EmitirRelatorioAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipo = request.getParameter("tipo");
        String codigo = request.getParameter("codigo");
        
        if(tipo.equals("") || codigo.equals("")){
            response.sendRedirect("index.jsp");
        } else {
            try {
                Relatorio relatorio = RelatorioFactory.create(tipo);
                relatorio.gerar(Integer.parseInt(codigo));
                request.setAttribute("relatorio", relatorio);
                RequestDispatcher view = request.getRequestDispatcher("/relatorio.jsp");
                view.forward(request, response);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
