package modelo;

public interface ShowEstado {

    public String getEstado();
    public String cadastrar(Show show);
    public String adiar(Show show);
    public String realizar(Show show);
    public String cancelar(Show show);
    
}
