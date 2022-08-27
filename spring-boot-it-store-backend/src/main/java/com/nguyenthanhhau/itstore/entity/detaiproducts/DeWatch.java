package com.nguyenthanhhau.itstore.entity.detaiproducts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nguyenthanhhau.itstore.entity.Product;
@Entity
@Table(name = "dewatch")
public class DeWatch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "screen")
	private String screen;

	@Column(name = "time_use")
	private String time_use;
	
	@Column(name = "system")
	private String system;
	
	@Column(name = "face_w")
	private String face_w;
	
	@Column(name = "face_diameter")
    protected String face_diameter;
	
	@Column(name = "feature")
    protected String feature;
	
	@Column(name = "pin")
    protected String pin;
	

	@Column(name = "design")
    protected String design;
	
	@Column(name="albert")
    protected String albert;
	
	@OneToOne
    @JoinColumn(name = "product_id_watch")
	private Product product;



	public DeWatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeWatch(long id, String screen, String time_use, String system, String face_w, String face_diameter,
			String feature, String pin, String design, String albert) {
		super();
		this.id = id;
		this.screen = screen;
		this.time_use = time_use;
		this.system = system;
		this.face_w = face_w;
		this.face_diameter = face_diameter;
		this.feature = feature;
		this.pin = pin;
		this.design = design;
		this.albert = albert;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getTime_use() {
		return time_use;
	}

	public void setTime_use(String time_use) {
		this.time_use = time_use;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getFace_w() {
		return face_w;
	}

	public void setFace_w(String face_w) {
		this.face_w = face_w;
	}

	public String getFace_diameter() {
		return face_diameter;
	}

	public void setFace_diameter(String face_diameter) {
		this.face_diameter = face_diameter;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getAlbert() {
		return albert;
	}

	public void setAlbert(String albert) {
		this.albert = albert;
	}

	@Override
	public String toString() {
		return "DeWatch [id=" + id + ", screen=" + screen + ", time_use=" + time_use + ", system=" + system
				+ ", face_w=" + face_w + ", face_diameter=" + face_diameter + ", feature=" + feature + ", pin=" + pin
				+ ", design=" + design + ", albert=" + albert + "]";
	}
	
	
}
