package david.TimeTrace.repository.activity;

import david.TimeTrace.domain.Activity;

import java.util.List;

public interface ActivityRepository
{
    public Activity save(Activity activity);

    public Activity findById(Long id);

    public List<Activity> findByMonth(int year, int month);

    public List<Activity> findByDay(int year, int month, int day);

    public void remove(Long id);

    public void clearAll();
}
