package com.pawconnect.controller;

import com.pawconnect.model.Rescue;
import com.pawconnect.repository.RescueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rescues")
public class RescueController {

    private final RescueRepository rescueRepository;

    public RescueController(RescueRepository rescueRepository) {
        this.rescueRepository = rescueRepository;
    }

    @PostMapping
    public Rescue addRescue(@RequestBody Rescue rescue) {
        return rescueRepository.save(rescue);
    }

    @GetMapping
    public List<Rescue> getRescues() {
        return rescueRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteRescue(@PathVariable Long id) {
        rescueRepository.deleteById(id);
    }
}