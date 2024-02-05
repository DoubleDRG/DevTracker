package david.TimeTrace.repository.activity;

import david.TimeTrace.domain.Activity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MySqlActivityRepository implements ActivityRepository
{
    private final EntityManager entityManager;

    @Override
    public Activity save(Activity activity)
    {
        entityManager.persist(activity);
        return activity;
    }

    @Override
    public Activity findById(Long id)
    {
        return entityManager.find(Activity.class, id);
    }

    @Override
    public List<Activity> findByMonth(int year, int month)
    {
        String query =
                "select a from Activity a where YEAR(a.timeInfo.startTime) =:year " +
                "and MONTH(a.timeInfo.startTime) =: month order by a.timeInfo.startTime desc";
        return entityManager.createQuery(query, Activity.class)
                .setParameter("year", year)
                .setParameter("month", month)
                .getResultList();
    }

    @Override
    public List<Activity> findByDay(int year, int month, int day)
    {
        String query =
                "select a from Activity a where YEAR(a.timeInfo.startTime) =:year " +
                "and MONTH(a.timeInfo.startTime) =:month " +
                "and DAY(a.timeInfo.startTime) =:day";
        return entityManager.createQuery(query, Activity.class)
                .setParameter("year", year)
                .setParameter("month", month)
                .setParameter("day", day)
                .getResultList();
    }

    @Override
    public void remove(Long id)
    {
        entityManager.remove(findById(id));
    }

    @Override
    public void clearAll()
    {
        entityManager.clear();
    }
}
