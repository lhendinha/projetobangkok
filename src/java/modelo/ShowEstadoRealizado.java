package modelo;


public class ShowEstadoRealizado implements ShowEstado {

    @Override
    public String getEstado() {
        return "Realizado";
    }

    @Override
    public String cadastrar(Show show) {
        return "O show não pode ser cadastrado, pois já foi realizado";
    }

    @Override
    public String adiar(Show show) {
        return "O show não pode ser adiado, pois já foi realizado";
    }

    @Override
    public String realizar(Show show) {
        return "O show não pode ser realizado, pois já está";
    }

    @Override
    public String cancelar(Show show) {
        return "O show não pode ser cancelado, pois já foi realizado";
    }
    
}
