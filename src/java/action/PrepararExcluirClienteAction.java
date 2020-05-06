package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararExcluirClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosClienteExcluir carregarDadosExcluir = new CarregarDadosClienteExcluir();
        carregarDadosExcluir.carregar(request, response);
    }
    
}
