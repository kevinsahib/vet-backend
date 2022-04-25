package floresnataren.duenios.modelo;

import javax.persistence.*;

@Entity
@Table (name="duenio")
public class Duenio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idDuenio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String  telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "username")
    private String username;

    public Duenio(){}

    public Duenio(int id, String nombre, String telefono, String direccion, String username) {
        this.idDuenio = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.username = username;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int id) {
        this.idDuenio = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
