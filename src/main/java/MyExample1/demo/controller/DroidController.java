package MyExample1.demo.controller;

import MyExample1.demo.model.Droid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/droid")
public class DroidController {
    private final Droid droid;

    public DroidController(Droid droid) {
        this.droid = droid;
    }

    @GetMapping
    public Droid getDroid() {
        return droid;
    }
}
