package fi.tamk.tiko;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Micky on 10.4.2017.
 */
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
    public Iterable<Exercise> findAll();
    public void delete(Exercise entity);
    public void delete(int id);
    public Exercise findOne(int id);


}
