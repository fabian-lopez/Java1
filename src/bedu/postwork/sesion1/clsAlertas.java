package bedu.postwork.sesion1;

public class clsAlertas {

    private String mensaje;
    private byte tipoMensaje;
    private boolean existeError;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public byte getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(byte tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }


    public boolean existeError() {
        return existeError;
    }

    public void setExisteError(boolean existeError) {
        this.existeError = existeError;
    }

    public clsAlertas (){}
    public clsAlertas (String mensaje, boolean existeError, byte tipoMensaje){
        this.mensaje = mensaje;
        this.existeError = existeError;
        this.tipoMensaje = tipoMensaje;
    }

}


