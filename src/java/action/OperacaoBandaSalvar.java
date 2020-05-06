package action;

import java.sql.SQLException;
import modelo.Banda;

public class OperacaoBandaSalvar extends OperacoesBanda{

    @Override
    protected void realizarCUD(Banda banda) throws ClassNotFoundException, SQLException {
        banda.salvar();
    }
    
}
