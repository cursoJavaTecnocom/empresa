package datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DATOSLABORALES database table.
 * 
 */
@Entity
@Table(name="DATOSLABORALES")
@NamedQuery(name="Datoslaborale.findAll", query="SELECT d FROM Datoslaborale d")
public class Datoslaborale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Transient
	private String texto;

	private int salario;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="IDCARGO")
	private Cargo cargo;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="datoslaborale")
	private List<Empleado> empleados;

	public Datoslaborale() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setDatoslaborale(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setDatoslaborale(null);

		return empleado;
	}

	public String getTexto() {
		return getCargo().getDescripcion()+" - "+getSalario();
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}