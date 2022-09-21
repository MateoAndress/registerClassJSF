
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbomaestro")
public class Maestro implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_maestro;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;

    public int getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(int id_maestro) {
        this.id_maestro = id_maestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_maestro;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maestro other = (Maestro) obj;
        if (this.id_maestro != other.id_maestro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Maestro{" + "id_maestro=" + id_maestro + '}';
    }
    
    
    
}
