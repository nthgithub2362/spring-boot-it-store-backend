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
;
@Entity
@Table(name = "delap")
public class DeLap {
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "cpu")
	private String cpu;

	@Column(name = "ram")
	private String ram;
	
	@Column(name = "hard_drive")
	private String hard_drive;
	
	@Column(name = "monitor")
	private String monitor;
	
	@Column(name = "graphic_card")
    protected String graphic_card;
	
	@Column(name = "connector")
    protected String connector;
	
	@Column(name = "opera_system")
    protected String opera_system;
	
	@Column(name = "design")
    protected String design;
	
	@Column(name="size")
    protected String size;
	
	@Column(name="time_launch")
    protected String time_launch;
	
	@OneToOne
    @JoinColumn(name = "product_id_lap")
	private Product product;
	
	public DeLap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeLap(long id, String cpu, String ram, String hard_drive, String monitor, String graphic_card,
			String connector, String opera_system, String design, String size, String time_launch) {
		super();
		this.id = id;
		this.cpu = cpu;
		this.ram = ram;
		this.hard_drive = hard_drive;
		this.monitor = monitor;
		this.graphic_card = graphic_card;
		this.connector = connector;
		this.opera_system = opera_system;
		this.design = design;
		this.size = size;
		this.time_launch = time_launch;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHard_drive() {
		return hard_drive;
	}

	public void setHard_drive(String hard_drive) {
		this.hard_drive = hard_drive;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getGraphic_card() {
		return graphic_card;
	}

	public void setGraphic_card(String graphic_card) {
		this.graphic_card = graphic_card;
	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public String getOpera_system() {
		return opera_system;
	}

	public void setOpera_system(String opera_system) {
		this.opera_system = opera_system;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTime_launch() {
		return time_launch;
	}

	public void setTime_launch(String time_launch) {
		this.time_launch = time_launch;
	}

	@Override
	public String toString() {
		return "DeLap [id=" + id + ", cpu=" + cpu + ", ram=" + ram + ", hard_drive=" + hard_drive + ", monitor="
				+ monitor + ", graphic_card=" + graphic_card + ", connector=" + connector + ", opera_system="
				+ opera_system + ", design=" + design + ", size=" + size + ", time_launch=" + time_launch + "]";
	}
	
}
