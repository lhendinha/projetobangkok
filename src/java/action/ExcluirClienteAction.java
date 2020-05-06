package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        OperacaoClienteExcluir excluirCliente = new OperacaoClienteExcluir();
        excluirCliente.realizarOperacao(request, response);
        
    }
    
}