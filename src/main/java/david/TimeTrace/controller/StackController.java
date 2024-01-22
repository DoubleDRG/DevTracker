package david.TimeTrace.controller;

import david.TimeTrace.domain.Stack;
import david.TimeTrace.service.stack.StackService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StackController
{
    private final StackService stackService;

    @PostConstruct
    void init()
    {
        Stack spring, mySql, java, typeScript, flask;

        String springUrl = "https://camo.githubusercontent.com/b908952ccc693aefea57c4f782dc41100366de07dee108f01cde69fd3c1e1bc1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465";
        String mySqlUrl = "https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465";
        String javaUrl = "https://camo.githubusercontent.com/3803468498d4b21719aced19028e21a6da499a5612de47661042d22997d8e8af/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d3030373339363f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465";
        String typeScriptUrl = "https://camo.githubusercontent.com/a00920b123df05b3df5e368e509f18bacd65bc5909698fb42be5f35063550f47/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f747970657363726970742d2532333030374143432e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d74797065736372697074266c6f676f436f6c6f723d7768697465";
        String flaskUrl = "https://camo.githubusercontent.com/4f51c7d1330d872d48ee0952d9000aab6466d1ca3cd58378f57bdbea4e41cda1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f666c61736b2d3030303030303f7374796c653d666f722d7468652d6261646765266c6f676f3d666c61736b266c6f676f436f6c6f723d7768697465";

        spring = Stack.builder()
                .name("Spring")
                .imageUrl(springUrl)
                .selected(true)
                .build();

        mySql = Stack.builder()
                .name("MySql")
                .imageUrl(mySqlUrl)
                .selected(true)
                .build();

        java = Stack.builder()
                .name("Java")
                .imageUrl(javaUrl)
                .selected(true)
                .build();

        typeScript = Stack.builder()
                .name("TypeScript")
                .imageUrl(typeScriptUrl)
                .selected(false)
                .build();

        flask = Stack.builder()
                .name("Flask")
                .imageUrl(flaskUrl)
                .selected(false)
                .build();

        stackService.register(spring);
        stackService.register(mySql);
        stackService.register(java);
        stackService.register(typeScript);
        stackService.register(flask);
    }

    //==스택관리 창 보여주기==//
    @GetMapping("/stackManagement")
    public String StackManageForm(Model model)
    {
        List<String> myStackImages = stackService.findSelectedStackUrls();
        List<String> notMyStack = stackService.findUnselectedStackNames();
        List<String> myStack = stackService.findSelectedStackNames();
        
        model.addAttribute("myStackImages", myStackImages);
        model.addAttribute("notMyStack", notMyStack);
        model.addAttribute("myStack", myStack);

        return "stackForm";
    }

    //==스택 추가==//
    @PostMapping("/stackManagement")
    public String StackSaveForm(@RequestParam(value = "addStacks", required = false) List<String> addStacks,
                                @RequestParam(value = "removeStacks", required = false) List<String> removeStacks)
    {
        stackService.addMyStack(addStacks);
        stackService.removeMyStack(removeStacks);
        return "redirect:/stackManagement";
    }
}
