package inei.asistencia.entity;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class UbigeoE {
    private String usuario;
    private String sede_operativa;
    private String local;
    private String direccion;
    private int aulas;
    private String estado;

    public UbigeoE(int aulas, String direccion, String estado, String local, String sede_operativa, String usuario) {
        this.aulas = aulas;
        this.direccion = direccion;
        this.estado = estado;
        this.local = local;
        this.sede_operativa = sede_operativa;
        this.usuario = usuario;
    }

    public int getAulas() {
        return aulas;
    }

    public void setAulas(int aulas) {
        this.aulas = aulas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSede_operativa() {
        return sede_operativa;
    }

    public void setSede_operativa(String sede_operativa) {
        this.sede_operativa = sede_operativa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
