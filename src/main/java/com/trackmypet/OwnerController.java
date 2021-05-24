package com.trackmypet;

import com.trackmypet.demo.api.OwnerRepository;
import com.trackmypet.demo.model.Owner;
import com.trackmypet.demo.model.OwnerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private OwnerRepository owners;

    @GetMapping("/{id}")
    public Owner findById(@PathVariable long id) {
        return owners.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
    }
    /*
    @GetMapping("/")
    List<Owner> newOwner() {
        //return owners.findAll();
    }*/
    @PostMapping("/")
    Owner newOwner(@RequestBody Owner newOwner) {
        return owners.save(newOwner);
    }
    @PutMapping("/{id}")
    Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable Long id) {
        return owners.findById(id)
                .map(owner -> {
                    owner.setName(newOwner.getName());
                    owner.setAddress(newOwner.getAddress());
                    owner.setEmail(newOwner.getEmail());
                    owner.setPhone(newOwner.getPhone());
                    return owners.save(owner);
                })
                .orElseGet(() -> {
                    newOwner.setId(id);
                    return owners.save(newOwner);
                });
    }

    @DeleteMapping("/{id}")
    void deleteOwner(@PathVariable Long id) {
        owners.deleteById(id);
    }
}
