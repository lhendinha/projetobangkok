package action;

import java.sql.SQLException;
import modelo.Cliente;

public class OperacaoClienteAlterar extends OperacoesCliente{

    @Override
    protected void realizarCUD(Cliente cliente) throws ClassNotFoundException, SQLException {
        cliente.alterar();
    }
    
}
