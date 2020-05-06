package modelo;


public class ShowEstadoCancelado implements ShowEstado {

    @Override
    public String getEstado() {
        return "Cancelado";
    }

    @Override
    public String cadastrar(Show show) {
        return "O show não pode ser cadastrado, pois está cancelado";
    }

    @Override
    public String adiar(Show show) {
        return "O show não pode ser adiado, pois está cancelado";
    }

    @Override
    public String realizar(Show show) {
        return "O show não pode ser realizado, pois está cancelado";
    }

    @Override
    public String cancelar(Show show) {
        return "O show não pode ser cancelado, pois já está";
    }
    
}
