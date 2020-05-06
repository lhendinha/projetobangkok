package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirBandaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoBandaExcluir excluirBanda = new OperacaoBandaExcluir();
        excluirBanda.realizarOperacao(request, response);
    }
    
}
