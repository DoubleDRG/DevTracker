package david.TimeTrace.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.dto.ActivityShowDto;
import david.TimeTrace.service.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class HomeController
{
    private final ActivityService activityService;

    @GetMapping({"/home/{year}/{month}","/{year}/{month}"})
    public String homeForm(@PathVariable("year") int year,
                           @PathVariable("month") int month,
                           Model model) throws JsonProcessingException
    {
        LocalDateTime previousMonth = LocalDateTime.of(year, month, 1, 0, 0, 0).minusMonths(1);
        LocalDateTime targetMonth = LocalDateTime.of(year, month, 1, 0, 0, 0);
        LocalDateTime nextMonth = LocalDateTime.of(year, month, 1, 0, 0, 0).plusMonths(1);

        Map<LocalDate, List<ActivityShowDto>> monthActivities = activityService.findActivitiesByMonth(year, month);

        model.addAttribute("previousMonth", previousMonth);
        model.addAttribute("targetMonth", targetMonth);
        model.addAttribute("nextMonth", nextMonth);

        model.addAttribute("monthActivities", monthActivities);

        return "home";
    }
}
