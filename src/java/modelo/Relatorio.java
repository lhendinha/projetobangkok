package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class Relatorio {

    protected int codigo;
    private String tipo;
    private String cabecalho;
    private List<String> corpo;
    private String rodape;

    public String getCabecalho() {
        return cabecalho;
    }

    public List<String> getCorpo() {
        return corpo;
    }

    public String getRodape() {
        return rodape;
    }
    
    public abstract String getTipo();

    public abstract List<String> preencher() throws ClassNotFoundException;

    public void gerar(int codigo) throws ClassNotFoundException {
        this.codigo = codigo;
        this.cabecalho = "Relatório de " + getTipo();
        this.corpo = preencher();
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        this.rodape = formatoData.format(data);
    }
    
}
