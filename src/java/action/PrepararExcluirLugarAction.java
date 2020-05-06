package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararExcluirLugarAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosLugarExcluir carregarDadosExcluir = new CarregarDadosLugarExcluir();
        carregarDadosExcluir.carregar(request, response);
    }
    
}
