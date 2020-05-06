package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarBandaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoBandaSalvar salvarBanda = new OperacaoBandaSalvar();
        salvarBanda.realizarOperacao(request, response);
    }
    
}
