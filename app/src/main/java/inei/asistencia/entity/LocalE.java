package inei.asistencia.entity;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class LocalE {

    private int cod_sede_operativa;
    private int cod_local_sede;
    private String nombreLocal;
    private String direccion;
    private String referencia;
    private int naula;
    private String estado;

    public LocalE(int cod_local_sede, int cod_sede_operativa, String direccion, String estado, int naula, String nombreLocal, String referencia) {
        this.cod_local_sede = cod_local_sede;
        this.cod_sede_operativa = cod_sede_operativa;
        this.direccion = direccion;
        this.estado = estado;
        this.naula = naula;
        this.nombreLocal = nombreLocal;
        this.referencia = referencia;
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

    public int getNaula() {
        return naula;
    }

    public void setNaula(int naula) {
        this.naula = naula;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
