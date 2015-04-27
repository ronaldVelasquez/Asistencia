package inei.asistencia.entity;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class UsuarioE {

    private int idUsuario;
    private String usuario;
    private String clave;
    private String nombresApellidos;
    private String estado;
    private int idRol;

    public UsuarioE(String clave, String estado, int idRol, int idUsuario, String nombresApellidos, String usuario) {
        this.clave = clave;
        this.estado = estado;
        this.idRol = idRol;
        this.idUsuario = idUsuario;
        this.nombresApellidos = nombresApellidos;
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
