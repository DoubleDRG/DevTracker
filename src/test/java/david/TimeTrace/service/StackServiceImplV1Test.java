package david.TimeTrace.service;

import david.TimeTrace.domain.Stack;
import david.TimeTrace.service.stack.StackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class StackServiceImplV1Test
{
    @Autowired
    private StackService stackService;

    private Stack spring;
    private Stack mySql;
    private Stack java;
    private Stack typeScript;
    private Stack flask;

    @BeforeEach
    void init()
    {
        stackService.clearAll();

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

    @Test
    void registerStack()
    {
        List<String> list = stackService.findSelectedStackNames();
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void findSelectedStackNames()
    {
        List<String> list = stackService.findSelectedStackNames();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list).contains(spring.getName());
        assertThat(list).contains(mySql.getName());
        assertThat(list).contains(java.getName());
    }

    @Test
    void findSelectedStackUrls()
    {
        List<String> list = stackService.findSelectedStackUrls();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list).contains(spring.getImageUrl());
        assertThat(list).contains(mySql.getImageUrl());
        assertThat(list).contains(java.getImageUrl());
    }

    @Test
    void findUnselectedStackNames()
    {
        List<String> list = stackService.findUnselectedStackNames();
        assertThat(list.size()).isEqualTo(2);
        assertThat(list).contains(flask.getName());
        assertThat(list).contains(typeScript.getName());
    }
}