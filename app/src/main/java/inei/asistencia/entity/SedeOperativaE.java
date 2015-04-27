package inei.asistencia.entity;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class SedeOperativaE {

    private int cod_sede_operativa;
    private String sede_operativa;

    public SedeOperativaE(int cod_sede_operativa, String sede_operativa) {
        this.cod_sede_operativa = cod_sede_operativa;
        this.sede_operativa = sede_operativa;
    }

    public int getCod_sede_operativa() {
        return cod_sede_operativa;
    }

    public void setCod_sede_operativa(int cod_sede_operativa) {
        this.cod_sede_operativa = cod_sede_operativa;
    }

    public String getSede_operativa() {
        return sede_operativa;
    }

    public void setSede_operativa(String sede_operativa) {
        this.sede_operativa = sede_operativa;
    }
}
