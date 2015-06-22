package datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/********** Modificado por David *****************/

/**
 * The persistent class for the HIJOS database table.
 * 
 */
@Entity
@Table(name="HIJOS")
@NamedQuery(name="Hijo.findAll", query="SELECT h FROM Hijo h")
public class Hijo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int chicas;

	private int chicos;
	@Transient
	private String texto;

	//bi-directional many-to-one association to Datospersonale
	@OneToMany(mappedBy="hijo")
	private List<Datospersonale> datospersonales;

	public Hijo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChicas() {
		return this.chicas;
	}

	public void setChicas(int chicas) {
		this.chicas = chicas;
	}

	public int getChicos() {
		return this.chicos;
	}

	public void setChicos(int chicos) {
		this.chicos = chicos;
	}

	public List<Datospersonale> getDatospersonales() {
		return this.datospersonales;
	}

	public void setDatospersonales(List<Datospersonale> datospersonales) {
		this.datospersonales = datospersonales;
	}

	public Datospersonale addDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().add(datospersonale);
		datospersonale.setHijo(this);

		return datospersonale;
	}

	public Datospersonale removeDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().remove(datospersonale);
		datospersonale.setHijo(null);

		return datospersonale;
	}

	public String getTexto() {
		return getChicos()+" - "+ getChicas();
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}