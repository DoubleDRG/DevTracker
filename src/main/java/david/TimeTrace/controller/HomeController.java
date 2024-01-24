package david.TimeTrace.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.dto.ActivityShowDto;
import david.TimeTrace.service.activity.ActivityService;
import david.TimeTrace.service.chart.ChartService;
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
    private final ChartService chartService;

    @GetMapping("/")
    public String redirectHome()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        return "redirect:/" + year + "/" + month;
    }

    @GetMapping({"/home/{year}/{month}","/{year}/{month}"})
    public String homeForm(@PathVariable("year") int year,
                           @PathVariable("month") int month,
                           Model model) throws JsonProcessingException
    {
        LocalDateTime lastLastMonth = LocalDateTime.of(year, month, 1, 0, 0, 0).minusMonths(2);
        LocalDateTime previousMonth = LocalDateTime.of(year, month, 1, 0, 0, 0).minusMonths(1);
        LocalDateTime targetMonth = LocalDateTime.of(year, month, 1, 0, 0, 0);
        LocalDateTime nextMonth = LocalDateTime.of(year, month, 1, 0, 0, 0).plusMonths(1);

        List<Long[]> monthDurations = chartService.get3monthDurations(targetMonth);

        Map<LocalDate, List<ActivityShowDto>> monthActivities = activityService.findActivitiesByMonth(year, month);

        model.addAttribute("lastLastMonth", lastLastMonth);
        model.addAttribute("previousMonth", previousMonth);
        model.addAttribute("targetMonth", targetMonth);
        model.addAttribute("nextMonth", nextMonth);

        model.addAttribute("monthDurations", monthDurations);

        model.addAttribute("monthActivities", monthActivities);

        return "home";
    }
}
