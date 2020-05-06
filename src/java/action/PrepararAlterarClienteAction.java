package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararAlterarClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosClienteAlterar carregarClienteAlterar = new CarregarDadosClienteAlterar();
        carregarClienteAlterar.carregar(request, response);
    }
}
