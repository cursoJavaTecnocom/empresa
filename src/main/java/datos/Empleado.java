package datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLEADOS database table.
 * 
 */
@Entity
@Table(name="EMPLEADOS")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String apellidos;

	private String direccion;

	private String edad;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Datoslaborale
	@ManyToOne
	@JoinColumn(name="IDDATOSLABORALES")
	private Datoslaborale datoslaborale;

	//bi-directional many-to-one association to Datospersonale
	@ManyToOne
	@JoinColumn(name="IDDATOSPERSONALES")
	private Datospersonale datospersonale;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="idEMPRESA")
	private Empresa empresa;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Datoslaborale getDatoslaborale() {
		return this.datoslaborale;
	}

	public void setDatoslaborale(Datoslaborale datoslaborale) {
		this.datoslaborale = datoslaborale;
	}

	public Datospersonale getDatospersonale() {
		return this.datospersonale;
	}

	public void setDatospersonale(Datospersonale datospersonale) {
		this.datospersonale = datospersonale;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}