package modelo;

import java.util.ArrayList;
import java.util.List;

public class RelatorioBanda extends Relatorio{

    @Override
    public String getTipo() {
        return "Banda";
    }

    @Override
    public List<String> preencher() throws ClassNotFoundException {
        List<String> dados = new ArrayList<>();
        Banda banda = Banda.obterBanda(this.codigo);
        
        dados.add("Código: " + banda.getCodigo());
        dados.add("Nome: " + banda.getNome());
        dados.add("Genero: " + banda.getGenero());
        
        return dados;
    }
    
}
