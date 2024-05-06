package com;


import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleController {
    private static final Map<Long, Vehicle> vehicles = new HashMap<>();

    @GetMapping("/{id}")
public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return Optional.ofNullable(vehicles.get(id));
    }

    @PostMapping
public Vehicle registerVehicle(@RequestBody VehicleRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(request.getMake());
        vehicle.setModel(request.getModel());

        
long newId = vehicles.size() + 1;
        vehicle.setId(newId);

        vehicles.put(newId, vehicle);

        return vehicle;
    }
}
