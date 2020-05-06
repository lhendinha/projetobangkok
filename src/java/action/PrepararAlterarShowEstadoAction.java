package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Show;

public class PrepararAlterarShowEstadoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int codigoShow = Integer.parseInt(request.getParameter("codigo"));
            Show showPesquisado = Show.obterShow(codigoShow);            
            request.setAttribute("show", showPesquisado);
            RequestDispatcher view = request.getRequestDispatcher("/alterarShowEstado.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            System.out.println("Exceção: ServletException");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Exceção: IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exceção: ClassNotFoundException");
            e.printStackTrace();
        }
    }
    
}