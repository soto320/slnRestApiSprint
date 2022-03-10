package com.examen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vivienda")
public class Vivienda {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipovivienda() {
		return tipovivienda;
	}

	public void setTipovivienda(String tipovivienda) {
		this.tipovivienda = tipovivienda;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Column(name = "tipovivienda", nullable = false,length = 45)
	private String tipovivienda;
	
	@Column(name = "area", nullable = false,length = 45)
	private String area;
	
	@Column(name = "ubicacion", nullable = false,length = 45)
	private String ubicacion;
	
	@Column(name = "precio", nullable = false,length = 45)
	private double precio;
}
