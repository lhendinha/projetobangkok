package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class RelatorioCliente extends Relatorio{

    @Override
    public String getTipo() {
        return "Cliente";
    }

    @Override
    public List<String> preencher() throws ClassNotFoundException {
        List<String> dados = new ArrayList<>();
        Cliente cliente = Cliente.obterCliente(this.codigo);
        
        dados.add("Codigo: " + cliente.getCodigo());
        dados.add("Nome: " + cliente.getNome());
        dados.add("Tipo: " + cliente.getTipo().getTipo());
        dados.add("Shows: ");
        for(Observable show: cliente.getShows()){
            Show s = (Show) show;
            dados.add(s.getDescricao());
        }
        
        return dados;
    }
    
}
