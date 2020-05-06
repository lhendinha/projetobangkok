package modelo;

public class ClienteTipoFactory {

    public static ClienteTipo create(String tipo){
        ClienteTipo tipoCliente = null;
        String nomeTipo = "modelo.Cliente" + tipo;
        Class classe = null;
        Object objeto = null;
        
        try {
            classe = Class.forName(nomeTipo);
            objeto = classe.newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

        if(!(objeto instanceof ClienteTipo)) return null;
        
        tipoCliente = (ClienteTipo) objeto;
        
        return tipoCliente;
    }
    
}