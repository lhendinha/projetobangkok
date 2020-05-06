package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Banda;
import modelo.Lugar;

public class PrepararSalvarShowAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("action", "Salvar");
            request.setAttribute("bandas", Banda.obterBandas());
            request.setAttribute("lugares", Lugar.obterLugares());
            RequestDispatcher view = request.getRequestDispatcher(ArquivosJSP.getInstancia().getManterShow());
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
