package david.TimeTrace.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.dto.ActivityDetailShowDto;
import david.TimeTrace.domain.dto.ActivitySaveDto;
import david.TimeTrace.service.activity.ActivityService;
import david.TimeTrace.service.stack.StackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ActivityController
{
    private final ActivityService activityService;
    private final StackService stackService;

    @GetMapping("/activity")
    public String activityAddForm(Model model)
    {
        List<String> stacks = stackService.findSelectedStackNames();
        model.addAttribute("stacks",stacks);
        return "/activity/activityAddForm";
    }

    @PostMapping("/activity")
    public String activitySave(@RequestParam("title") String title,
                               @RequestParam(value = "stacks", required = false) List<String> stacks,
                               @RequestParam("startTime") LocalDateTime startTime,
                               @RequestParam("endTime") LocalDateTime endTime,
                               @RequestParam(value = "content", required = false) String content) throws JsonProcessingException
    {
        ActivitySaveDto saveDto = new ActivitySaveDto(title, stacks, startTime, endTime, content);
        activityService.save(saveDto);
        return "redirect:/" + startTime.getYear() +"/"+startTime.getMonthValue();
    }

    //==상세 글 조회==//
    @GetMapping("/activity/{id}")
    public String activityDetailForm(@PathVariable("id") Long id, Model model) throws JsonProcessingException
    {
        ActivityDetailShowDto showDto = activityService.findById(id);
        model.addAttribute("activity", showDto);
        return "/activity/activityDetailForm";
    }
}
