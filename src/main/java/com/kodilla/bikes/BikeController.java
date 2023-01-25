package com.kodilla.bikes;

import com.kodilla.exception.BikeNotFoundException;
import com.kodilla.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BikeController {

    private final BikeService bikeService;
    private final BikeMapper bikeMapper;

    @GetMapping
    public ResponseEntity<List<BikeDto>> getBikes() {
        List<Bike> bikes = bikeService.getAllBikes();
        return ResponseEntity.ok(bikeMapper.mapToBikeListDto(bikes));
    }
    @GetMapping(value = "{bikeId}")
    public ResponseEntity<BikeDto> getBike(@PathVariable Long bikeId) throws BikeNotFoundException {
        return ResponseEntity.ok(bikeMapper.mapToBikeDto(bikeService.getBike(bikeId)));
    }

    @DeleteMapping(value = "{bikeId}")
    public ResponseEntity<Void> deleteBike(@PathVariable Long bikeId) throws BikeNotFoundException {
        bikeService.deleteBike(bikeService.getBike(bikeId).getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBike(@RequestBody BikeDto bikeDto) {
        Bike bike = bikeMapper.mapToBike(bikeDto);
        bikeService.saveBike(bike);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BikeDto> updateBike(@RequestBody BikeDto bikeDto) {
        Bike bike = bikeMapper.mapToBike(bikeDto);
        Bike savedBike = bikeService.saveBike(bike);
        return ResponseEntity.ok(bikeMapper.mapToBikeDto(savedBike));
    }
}
