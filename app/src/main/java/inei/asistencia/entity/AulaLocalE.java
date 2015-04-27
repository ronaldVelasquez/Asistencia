package inei.asistencia.entity;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class AulaLocalE {

    private int cod_sede_operativa;
    private int cod_local_sede;
    private int nro_aula;

    public AulaLocalE(int cod_local_sede, int cod_sede_operativa, int nro_aula) {
        this.cod_local_sede = cod_local_sede;
        this.cod_sede_operativa = cod_sede_operativa;
        this.nro_aula = nro_aula;
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

    public int getNro_aula() {
        return nro_aula;
    }

    public void setNro_aula(int nro_aula) {
        this.nro_aula = nro_aula;
    }
}
