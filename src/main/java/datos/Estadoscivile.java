package datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTADOSCIVILES database table.
 * 
 */
@Entity
@Table(name="ESTADOSCIVILES")
@NamedQuery(name="Estadoscivile.findAll", query="SELECT e FROM Estadoscivile e")
public class Estadoscivile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Datospersonale
	@OneToMany(mappedBy="estadoscivile")
	private List<Datospersonale> datospersonales;

	public Estadoscivile() {
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

	public List<Datospersonale> getDatospersonales() {
		return this.datospersonales;
	}

	public void setDatospersonales(List<Datospersonale> datospersonales) {
		this.datospersonales = datospersonales;
	}

	public Datospersonale addDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().add(datospersonale);
		datospersonale.setEstadoscivile(this);

		return datospersonale;
	}

	public Datospersonale removeDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().remove(datospersonale);
		datospersonale.setEstadoscivile(null);

		return datospersonale;
	}

}