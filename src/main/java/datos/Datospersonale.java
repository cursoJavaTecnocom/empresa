package datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DATOSPERSONALES database table.
 * 
 */
@Entity
@Table(name="DATOSPERSONALES")
@NamedQuery(name="Datospersonale.findAll", query="SELECT d FROM Datospersonale d")
public class Datospersonale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Transient
	private String texto;

	//bi-directional many-to-one association to Estadoscivile
	@ManyToOne
	@JoinColumn(name="IDESTADOSCIVILES")
	private Estadoscivile estadoscivile;

	//bi-directional many-to-one association to Hijo
	@ManyToOne
	@JoinColumn(name="IDHIJOS")
	private Hijo hijo;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="datospersonale")
	private List<Empleado> empleados;

	public Datospersonale() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estadoscivile getEstadoscivile() {
		return this.estadoscivile;
	}

	public void setEstadoscivile(Estadoscivile estadoscivile) {
		this.estadoscivile = estadoscivile;
	}

	public Hijo getHijo() {
		return this.hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setDatospersonale(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setDatospersonale(null);

		return empleado;
	}

	
	public String getTexto() {
		return getEstadoscivile().getDescripcion()+" - "+getHijo().getChicos()+" - "+getHijo().getChicas();
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}