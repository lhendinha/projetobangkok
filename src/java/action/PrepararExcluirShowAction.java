package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararExcluirShowAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosShowExcluir carregarExcluirShow = new CarregarDadosShowExcluir();
        carregarExcluirShow.carregar(request, response);
    }
    
}