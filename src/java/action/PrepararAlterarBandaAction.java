package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararAlterarBandaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosBandaAlterar carregarBandaAlterar = new CarregarDadosBandaAlterar();
        carregarBandaAlterar.carregar(request, response);
    }
    
}