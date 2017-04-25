package fi.tamk.tiko;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fi.tamk.tiko.Exercise;

/**
 * Created by Micky on 10.4.2017.
 */

@Entity
public class Workout {


    private int id;
    @ElementCollection(targetClass=Integer.class)
    private Set<Exercise> exercises;
    private int points;
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }


    @OneToMany(mappedBy="workout", cascade = CascadeType.ALL)
    @JsonManagedReference
    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }


    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
        if(exercise.getWorkout() != this) {
            exercise.setWorkout(this);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Workout() {
        this.points = 0;
        exercises = new HashSet<Exercise>();

    }

}
