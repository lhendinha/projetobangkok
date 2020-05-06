package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirLugarAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OperacaoLugarExcluir excluirLugar = new OperacaoLugarExcluir();
        excluirLugar.realizarOperacao(request, response);
    }
    
}
