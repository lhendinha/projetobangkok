package action;

public class ArquivosJSP {
     
    private static ArquivosJSP instancia = new ArquivosJSP();
    
    private String paginaInicial = "/index.jsp";
    private String lerBandas = "/banda.jsp";
    private String manterBanda = "/manterBanda.jsp";
    private String lerClientes = "/cliente.jsp";
    private String manterCliente = "/manterCliente.jsp";
    private String lerLugares = "/lugar.jsp";
    private String manterLugar = "/manterLugar.jsp";
    private String lerShows = "/show.jsp";
    private String manterShow = "/manterShow.jsp";
    private String smsSucesso = "/sucesso.jsp";
    private String smsErro = "/erro.jsp";

    private ArquivosJSP() {};

    public static ArquivosJSP getInstancia() {
        return instancia;
    }

    public String getPaginaInicial() {
        return paginaInicial;
    }

    public String getLerBandas() {
        return lerBandas;
    }

    public String getManterBanda() {
        return manterBanda;
    }

    public String getLerClientes() {
        return lerClientes;
    }

    public String getManterCliente() {
        return manterCliente;
    }

    public String getLerLugares() {
        return lerLugares;
    }

    public String getManterLugar() {
        return manterLugar;
    }

    public String getLerShows() {
        return lerShows;
    }

    public String getManterShow() {
        return manterShow;
    }

    public String getSmsSucesso() {
        return smsSucesso;
    }

    public String getSmsErro() {
        return smsErro;
    }
    
}
