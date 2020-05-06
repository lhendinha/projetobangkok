package action;

import java.sql.SQLException;
import modelo.Cliente;

public class OperacaoClienteSalvar extends OperacoesCliente{

    @Override
    protected void realizarCUD(Cliente cliente) throws ClassNotFoundException, SQLException {
        cliente.salvar();
    }
    
}
