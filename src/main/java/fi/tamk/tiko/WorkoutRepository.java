package fi.tamk.tiko;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Micky on 10.4.2017.
 */
public interface WorkoutRepository extends CrudRepository<Workout, Integer> {
    public Iterable<Workout> findAll();
    public void delete(Workout entity);
    public void delete(int id);
    public Workout findOne(int id);


}
