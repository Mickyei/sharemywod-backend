
package fi.tamk.tiko;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

// This class acts as a controller.
// Usually when using @Controller, you will use also @RequestMapping
@RestController
public class MyController {




    @Autowired
    WorkoutRepository database;

    @Autowired
    ExerciseRepository exerciseRepository;

    public MyController() {

    }

    @RequestMapping(value = "/workouts",  method=RequestMethod.POST)
    public void saveLocation(@RequestBody Workout c) {

        database.save(c);
    }

    @RequestMapping(value = "/workouts",  method=RequestMethod.GET)
    public Iterable<Workout> fetchLocation() {
        return database.findAll();
    }

    @RequestMapping(value = "/workouts/{id}",  method=RequestMethod.GET)
    public Workout fetchLocation(@PathVariable int id) {
        for(Workout c : database.findAll()) {
            if(c.getId() == id) {
                return c;
            }
        }
        return null;
    }


    @RequestMapping(value = "/exercises",  method=RequestMethod.POST)
    public void saveExercise(@RequestBody Exercise c) {

        exerciseRepository.save(c);
    }

    @RequestMapping(value = "/exercises",  method=RequestMethod.GET)
    public Iterable<Exercise> fetchExercise() {
        return exerciseRepository.findAll();
    }

    @RequestMapping(value = "/exercises/{id}",  method=RequestMethod.GET)
    public Exercise fetchExercise(@PathVariable int id) {
        for(Exercise c : exerciseRepository.findAll()) {
            if(c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}

