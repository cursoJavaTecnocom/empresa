package datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/********** Modificado por David ***************/
/**
 * The persistent class for the CARGOS database table.
 * 
 */
@Entity
@Table(name="CARGOS")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Datoslaborale
	@OneToMany(mappedBy="cargo")
	private List<Datoslaborale> datoslaborales;

	public Cargo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Datoslaborale> getDatoslaborales() {
		return this.datoslaborales;
	}

	public void setDatoslaborales(List<Datoslaborale> datoslaborales) {
		this.datoslaborales = datoslaborales;
	}

	public Datoslaborale addDatoslaborale(Datoslaborale datoslaborale) {
		getDatoslaborales().add(datoslaborale);
		datoslaborale.setCargo(this);

		return datoslaborale;
	}

	public Datoslaborale removeDatoslaborale(Datoslaborale datoslaborale) {
		getDatoslaborales().remove(datoslaborale);
		datoslaborale.setCargo(null);

		return datoslaborale;
	}

}