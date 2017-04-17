package fi.tamk.tiko;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by Micky on 10.4.2017.
 */

@Entity
public class Exercise {

    private int id;
    private int amount;
    private String value;
    private String name;
    private int sets;

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "workout_id")
    @JsonBackReference
    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
        if(workout.getExercises().contains(this)) {
            workout.getExercises().add(this);
        }
    }

    public int getAmount() {
        return amount;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exercise() {
        workout = new Workout();
    }

    @Override
    public String toString() {
        return "{ \"id\":" + id + ", \"name\": \"" + name + "\"" +
                ", \"amount\" :" + amount + ", \"value\": " + "\"" + value + "\"," +
                "\"sets\":" + sets + ", \"workout_id\":" + workout.getId() + "}";
    }


}
