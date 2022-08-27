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
@Table(name = "dephone")
public class DePhone {
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "screen")
	private String screen;

	@Column(name = "opera_system")
	private String opera_system;
	
	@Column(name = "rear_camera")
	private String rear_camera;
	
	@Column(name = "front_camera")
	private String front_camera;
	
	@Column(name = "chip")
    protected String chip;
	
	@Column(name = "ram")
    protected String ram;
	
	@Column(name = "rom")
    protected String rom;
	
	@Column(name = "sim")
    protected String sim;
	
	@Column(name="pin_power")
    protected String pin_power;
	
	@OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	

	



	

	public DePhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DePhone(long id, String screen, String opera_system, String rear_camera, String front_camera, String chip,
			String ram, String rom, String sim, String pin_power) {
		super();
		this.id = id;
		this.screen = screen;
		this.opera_system = opera_system;
		this.rear_camera = rear_camera;
		this.front_camera = front_camera;
		this.chip = chip;
		this.ram = ram;
		this.rom = rom;
		this.sim = sim;
		this.pin_power = pin_power;
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

	public String getOpera_system() {
		return opera_system;
	}

	public void setOpera_system(String opera_system) {
		this.opera_system = opera_system;
	}

	public String getRear_camera() {
		return rear_camera;
	}

	public void setRear_camera(String rear_camera) {
		this.rear_camera = rear_camera;
	}

	public String getFront_camera() {
		return front_camera;
	}

	public void setFront_camera(String front_camera) {
		this.front_camera = front_camera;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getPin_power() {
		return pin_power;
	}

	public void setPin_power(String pin_power) {
		this.pin_power = pin_power;
	}

	@Override
	public String toString() {
		return "DePhone [id=" + id + ", screen=" + screen + ", opera_system=" + opera_system + ", rear_camera="
				+ rear_camera + ", front_camera=" + front_camera + ", chip=" + chip + ", ram=" + ram + ", rom=" + rom
				+ ", sim=" + sim + ", pin_power=" + pin_power + "]";
	}
	
}
