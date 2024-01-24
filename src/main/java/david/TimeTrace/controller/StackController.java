package david.TimeTrace.controller;

import david.TimeTrace.domain.Stack;
import david.TimeTrace.service.stack.StackService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StackController
{
    private final StackService stackService;

    //==스택관리 창 보여주기==//
    @GetMapping("/stack")
    public String StackManageForm(Model model)
    {
        LocalDateTime now = LocalDateTime.now();
        List<String> myStackImages = stackService.findSelectedStackUrls();
        List<String> notMyStack = stackService.findUnselectedStackNames();
        List<String> myStack = stackService.findSelectedStackNames();

        model.addAttribute("now", now);
        model.addAttribute("myStackImages", myStackImages);
        model.addAttribute("notMyStack", notMyStack);
        model.addAttribute("myStack", myStack);

        return "stackForm";
    }

    //==스택 추가==//
    @PostMapping("/stack")
    public String StackSaveForm(@RequestParam(value = "addStacks", required = false) List<String> addStacks,
                                @RequestParam(value = "removeStacks", required = false) List<String> removeStacks)
    {
        stackService.addMyStack(addStacks);
        stackService.removeMyStack(removeStacks);
        return "redirect:/stack";
    }
}
