package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarLugarAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoLugarSalvar salvarLugar = new OperacaoLugarSalvar();
        salvarLugar.realizarOperacao(request, response);
    }
    
}
