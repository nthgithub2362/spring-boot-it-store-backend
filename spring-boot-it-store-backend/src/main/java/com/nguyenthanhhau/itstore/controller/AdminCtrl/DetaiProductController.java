package com.nguyenthanhhau.itstore.controller.AdminCtrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.detaiproducts.DeLap;
import com.nguyenthanhhau.itstore.entity.detaiproducts.DePhone;
import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.repository.DeLapRepository;
import com.nguyenthanhhau.itstore.repository.DePhoneRepository;
import com.nguyenthanhhau.itstore.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DetaiProductController {
	@Autowired
	private DePhoneRepository dePhoneRepository;
	@Autowired
	private DeLapRepository deLapRepository;
	
	//PARAMATER PHONE//
	@GetMapping("/parameterPhone/{id}")
	public ResponseEntity<DePhone> getParameterPhoneById(@PathVariable Long id) {
		DePhone dePhone = dePhoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exits with id:" + id));
		return ResponseEntity.ok(dePhone);
	}
	@PostMapping("/addParameterPhone")
	public DePhone ParameterPhone(@RequestBody DePhone dePhone) {
		return dePhoneRepository.save(dePhone);
	}
	@PutMapping("/updateParameterPhone/{id}")
	public ResponseEntity<DePhone> updateDePhone(@PathVariable Long id, @RequestBody DePhone dePhoneDetail) {
		DePhone dePhone = dePhoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Detail Phone not exits with id:" + id));
		dePhone.setId(dePhoneDetail.getId());
		dePhone.setScreen(dePhoneDetail.getScreen());
		dePhone.setOpera_system(dePhoneDetail.getOpera_system());
		dePhone.setRear_camera(dePhoneDetail.getRear_camera());
		dePhone.setFront_camera(dePhoneDetail.getFront_camera());
		dePhone.setChip(dePhoneDetail.getChip());
		dePhone.setRam(dePhoneDetail.getRam());
		dePhone.setRom(dePhoneDetail.getRom());
		dePhone.setSim(dePhoneDetail.getSim());
		dePhone.setPin_power(dePhoneDetail.getPin_power());
		
		
		DePhone updateddephone = dePhoneRepository.save(dePhone);
		return ResponseEntity.ok(updateddephone);
	}
	@DeleteMapping("/parameterPhone/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteparameterPhone(@PathVariable Long id) {
		DePhone product = dePhoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DePhone not exits with id:" + id));

		dePhoneRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	//PARAMATER LAPTOP//
		@GetMapping("/parameterLaptop/{id}")
		public ResponseEntity<DeLap> getParameterLapById(@PathVariable Long id) {
			DeLap deLap = deLapRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Product not exits with id:" + id));
			return ResponseEntity.ok(deLap);
		}
		@PostMapping("/addParameterLaptop")
		public DeLap ParameterLaptop(@RequestBody DeLap deLap) {
			return deLapRepository.save(deLap);
		}
		@PutMapping("/updateParameterDeLap/{id}")
		public ResponseEntity<DeLap> updateDeLap(@PathVariable Long id, @RequestBody DeLap deLapDetail) {
			DeLap deLap = deLapRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Detail Laptop not exits with id:" + id));
			deLap.setId(deLapDetail.getId());
			deLap.setCpu(deLapDetail.getCpu());
			deLap.setRam(deLapDetail.getRam());
			deLap.setHard_drive(deLapDetail.getHard_drive());
			deLap.setMonitor(deLapDetail.getMonitor());
			deLap.setGraphic_card(deLapDetail.getGraphic_card());
			deLap.setConnector(deLapDetail.getConnector());
			deLap.setOpera_system(deLapDetail.getOpera_system());
			deLap.setDesign(deLapDetail.getDesign());
			deLap.setSize(deLapDetail.getSize());
			deLap.setTime_launch(deLapDetail.getTime_launch());
			
			DeLap updateddelap = deLapRepository.save(deLap);
			return ResponseEntity.ok(updateddelap);
		}
		@DeleteMapping("/parameterLaptop/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteparameterLaptop(@PathVariable Long id) {
			DeLap product = deLapRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("DeLap not exits with id:" + id));

			deLapRepository.delete(product);
			Map<String, Boolean> response = new HashMap<>();
			response.put("delete", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}
