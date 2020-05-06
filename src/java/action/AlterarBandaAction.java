package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarBandaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoBandaAlterar alterarBanda = new OperacaoBandaAlterar();
        alterarBanda.realizarOperacao(request, response);
    }
    
}
