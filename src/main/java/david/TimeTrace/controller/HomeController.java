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
        Map<LocalDate, List<ActivityShowDto>> monthActivities = activityService.findActivitiesByMonth(year, month);
        // 최신순
        // 날짜1[Activity1, Activity2, ... ]
        // 날짜2[Activity1, Activity2, ... ]
        // 날짜3[Activity1, Activity2, ... ]
        // 날짜4[Activity1, Activity2, ... ]
        model.addAttribute("monthActivities", monthActivities);
        return "home";
    }
}
