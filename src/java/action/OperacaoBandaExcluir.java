package action;

import java.sql.SQLException;
import modelo.Banda;

public class OperacaoBandaExcluir extends OperacoesBanda{

    @Override
    protected void realizarCUD(Banda banda) throws ClassNotFoundException, SQLException {
        banda.excluir();
    }
    
}
