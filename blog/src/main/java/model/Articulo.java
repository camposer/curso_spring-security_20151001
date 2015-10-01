package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="ARTICULO")
@NamedQuery(name="Articulo.findAll", query="SELECT a FROM Articulo a")
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=500)
	private String contenido;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Status status;

	@Column(nullable=false, length=250)
	private String titulo;

	public static enum Status {
		ACTIVO, INACTIVO;
	}
	
	public Articulo() {
	}

	public Articulo(String titulo, String contenido, Date fecha) {
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}