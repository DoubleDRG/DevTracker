package david.TimeTrace.repository.activity;

import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.TimeAndDuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MySqlActivityRepositoryTest
{
    @Autowired
    private ActivityRepository activityRepository;

    private Activity springActivity;
    private Activity jpaActivity;
    private Activity flaskActivity;
    LocalDateTime now = LocalDateTime.of(2024, 1, 20, 13, 0);

    @BeforeEach
    void init()
    {
        activityRepository.clearAll();

        springActivity = Activity.builder()
                .title("springTitle")
                .stacks("{'spring':'springUrl','jpa':'jpaUrl'}")
                .startTime(now.minusHours(1))
                .endTime(now)
                .duration(Duration.between(now.minusHours(1), now))
                .content("content")
                .build();

        jpaActivity = Activity.builder()
                .title("jpaTitle")
                .stacks("{'spring':'springUrl','jpa':'jpaUrl'}")
                .startTime(now.minusHours(2))
                .endTime(now.minusHours(1))
                .duration(Duration.between(now.minusHours(2), now.minusHours(1)))
                .content("content")
                .build();


        flaskActivity = Activity.builder()
                .title("flaskTitle")
                .stacks("{'flask':'flaskUrl','mongoDB':'mongoUrl'}")
                .startTime(now.minusMonths(1))
                .endTime(now.minusMonths(1))
                .duration(Duration.between(now.minusMonths(1), now.minusMonths(1)))
                .content("content")
                .build();

        activityRepository.save(springActivity);
        activityRepository.save(jpaActivity);
        activityRepository.save(flaskActivity);
    }

    @Test
    void findById()
    {
        assertThat(activityRepository.findById(springActivity.getId()))
                .isEqualTo(springActivity);
    }

    @Test
    void findByMonth()
    {
        int year = now.getYear();
        int month = now.getMonthValue();

        List<Activity> list = activityRepository.findByMonth(year, month);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(springActivity)).isEqualTo(true);
        assertThat(list.contains(jpaActivity)).isEqualTo(true);
        assertThat(list.contains(flaskActivity)).isEqualTo(false);
    }

    @Test
    void findByDay()
    {
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        List<Activity> list = activityRepository.findByDay(year, month, day);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(springActivity)).isEqualTo(true);
        assertThat(list.contains(jpaActivity)).isEqualTo(true);
    }

    @Test
    void findLast4MonthDuration()
    {
        List<TimeAndDuration> list = activityRepository.findLast4MonthDuration(now);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.contains(TimeAndDuration.builder()
                .startTime(now.minusHours(1))
                .duration(Duration.ofHours(1))
                .build())).isEqualTo(true);

        assertThat(list.get(0)).isEqualTo(TimeAndDuration.builder()
                .startTime(flaskActivity.getStartTime())
                .duration(flaskActivity.getDuration())
                .build());
    }

    @Test
    void remove()
    {
        Activity find = activityRepository.findById(springActivity.getId());
        activityRepository.remove(find.getId());

        List<Activity> list = activityRepository.findByMonth(now.getYear(), now.getMonthValue());

        assertThat(list.size()).isEqualTo(1);

        List<Activity> list2 = activityRepository.findByMonth(now.getYear(), now.getMonthValue());
        assertThat(list2.contains(springActivity)).isEqualTo(false);
        assertThat(list2.contains(jpaActivity)).isEqualTo(true);
        assertThat(list2.contains(flaskActivity)).isEqualTo(false);
    }
}