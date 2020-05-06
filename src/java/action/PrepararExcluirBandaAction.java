package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararExcluirBandaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CarregarDadosBandaExcluir carregarBandaExcluir = new CarregarDadosBandaExcluir();
        carregarBandaExcluir.carregar(request, response);
    }
    
}
