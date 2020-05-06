package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarShowAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoShowSalvar salvarShow = new OperacaoShowSalvar();
        salvarShow.realizarOperacao(request, response);
    }
    
}
