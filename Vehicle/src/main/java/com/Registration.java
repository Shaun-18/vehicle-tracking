package com;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

public class Registration {
	

	
	@RestController
	@RequestMapping("/api/vehicles")
	public class VehicleController {

	    @GetMapping("")
	    public List<Vehicle> getAllVehicles() {
			return getAllVehicles();
	        
	    }

	    @PostMapping("")
	    public Vehicle registerVehicle(@RequestBody Vehicle vehicle) {
			return vehicle;
	       
	    }

	    @GetMapping("/{registrationNumber}")
	    public Optional<Vehicle> getVehicle(@PathVariable String registrationNumber) {
			return null;
	        
	    }
	}

}
