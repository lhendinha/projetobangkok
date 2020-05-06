package action;

import java.sql.SQLException;
import modelo.Show;

public class OperacaoShowAlterar extends OperacoesShow{

    @Override
    protected void realizarCUD(Show show) throws ClassNotFoundException, SQLException {
        show.alterar();
    }
    
}
