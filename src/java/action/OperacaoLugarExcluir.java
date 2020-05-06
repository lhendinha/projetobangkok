package action;

import java.sql.SQLException;
import modelo.Lugar;

public class OperacaoLugarExcluir extends OperacoesLugar{

    @Override
    protected void realizarCUD(Lugar lugar) throws ClassNotFoundException, SQLException {
        lugar.excluir();
    }
    
}
