package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarShowAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoShowAlterar alterarShow = new OperacaoShowAlterar();
        alterarShow.realizarOperacao(request, response);
    }
    
}
