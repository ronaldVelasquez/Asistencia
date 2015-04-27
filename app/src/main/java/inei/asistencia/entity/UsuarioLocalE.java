package inei.asistencia.entity;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class UsuarioLocalE {

    private int idUsuario;
    private int cod_sede_operativa;
    private int cod_local_sede;

    public UsuarioLocalE(int cod_local_sede, int cod_sede_operativa, int idUsuario) {
        this.cod_local_sede = cod_local_sede;
        this.cod_sede_operativa = cod_sede_operativa;
        this.idUsuario = idUsuario;
    }

    public int getCod_local_sede() {
        return cod_local_sede;
    }

    public void setCod_local_sede(int cod_local_sede) {
        this.cod_local_sede = cod_local_sede;
    }

    public int getCod_sede_operativa() {
        return cod_sede_operativa;
    }

    public void setCod_sede_operativa(int cod_sede_operativa) {
        this.cod_sede_operativa = cod_sede_operativa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
