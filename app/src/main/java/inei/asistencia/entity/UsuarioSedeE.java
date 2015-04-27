package inei.asistencia.entity;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class UsuarioSedeE {

    private int idUsuario;
    private String cod_sede_operativa;

    public UsuarioSedeE(String cod_sede_operativa, int idUsuario) {
        this.cod_sede_operativa = cod_sede_operativa;
        this.idUsuario = idUsuario;
    }


    public String getCod_sede_operativa() {
        return cod_sede_operativa;
    }

    public void setCod_sede_operativa(String cod_sede_operativa) {
        this.cod_sede_operativa = cod_sede_operativa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
