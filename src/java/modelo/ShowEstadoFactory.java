package modelo;

public class ShowEstadoFactory {

    public static ShowEstado create(String tipo){
        ShowEstado show = null;
        String estadoShow = "modelo." + tipo;
        Class classe = null;
        Object objeto = null;
        
        try {
            classe = Class.forName(estadoShow);
            objeto = classe.newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        
        if(!(objeto instanceof ShowEstado)) return  null;
        
        show = (ShowEstado) objeto;
        
        return show;
    }
    
}
