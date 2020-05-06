package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararAlterarLugarAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosLugarAlterar carregarDadosAlterar = new CarregarDadosLugarAlterar();
        carregarDadosAlterar.carregar(request, response);
    }
    
}