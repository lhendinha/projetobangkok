package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararAlterarShowAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosShowAlterar carregarAlterarShow = new CarregarDadosShowAlterar();
        carregarAlterarShow.carregar(request, response);
    }
    
}