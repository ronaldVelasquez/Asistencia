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
    private int cod_sede_operativa;
    private int cod_local_sede;

    public UbigeoE(int aulas, int cod_local_sede, int cod_sede_operativa, String direccion, String estado, String local, String sede_operativa, String usuario) {
        this.aulas = aulas;
        this.cod_local_sede = cod_local_sede;
        this.cod_sede_operativa = cod_sede_operativa;
        this.direccion = direccion;
        this.estado = estado;
        this.local = local;
        this.sede_operativa = sede_operativa;
        this.usuario = usuario;
    }

    public UbigeoE() {
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
