package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarLugarAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoLugarAlterar alterarLugar = new OperacaoLugarAlterar();
        alterarLugar.realizarOperacao(request, response);
    }
    
}
