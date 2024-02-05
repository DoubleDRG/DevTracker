package david.TimeTrace.config.dummydata;

import david.TimeTrace.domain.Stack;
import david.TimeTrace.service.stack.StackService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StackInit
{
    private final StackService stackService;

    @PostConstruct
    void init()
    {
        Stack spring, hibernate, thymeleaf, mySql, java, cpp, python, typeScript, flask, aws, docker, githubActions, git, github, html, linux, ubuntu;

        String springUrl = "https://camo.githubusercontent.com/b908952ccc693aefea57c4f782dc41100366de07dee108f01cde69fd3c1e1bc1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465";
        String hibernateUrl = "https://camo.githubusercontent.com/3cfd3a68bd2a9a7a46bfb2baac67777f164122d1c8d5947eddd465442b588037/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f48696265726e6174652d3539363636433f7374796c653d666f722d7468652d6261646765266c6f676f3d48696265726e617465266c6f676f436f6c6f723d7768697465";
        String thymeleafUrl = "https://camo.githubusercontent.com/1b65095a3ebd2868655be17366b060c61ce9042730790e9b554651c6ccdf8e35/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5468796d656c6561662d2532333030354330462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d5468796d656c656166266c6f676f436f6c6f723d7768697465";
        String mySqlUrl = "https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465";
        String javaUrl = "https://camo.githubusercontent.com/3803468498d4b21719aced19028e21a6da499a5612de47661042d22997d8e8af/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d3030373339363f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465";
        String pythonUrl = "https://camo.githubusercontent.com/0562f16a4ae7e35dae6087bf8b7805fb7e664a9e7e20ae6d163d94e56b94f32d/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f707974686f6e2d3336373041303f7374796c653d666f722d7468652d6261646765266c6f676f3d707974686f6e266c6f676f436f6c6f723d666664643534";
        String cppUrl = "https://camo.githubusercontent.com/69ab3d5d4f1a013fb242d8ab82efc118146fcb72791937a0495f05c829d0f9b2/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f632b2b2d2532333030353939432e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d63253242253242266c6f676f436f6c6f723d7768697465";
        String typeScriptUrl = "https://camo.githubusercontent.com/a00920b123df05b3df5e368e509f18bacd65bc5909698fb42be5f35063550f47/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f747970657363726970742d2532333030374143432e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d74797065736372697074266c6f676f436f6c6f723d7768697465";
        String flaskUrl = "https://camo.githubusercontent.com/4f51c7d1330d872d48ee0952d9000aab6466d1ca3cd58378f57bdbea4e41cda1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f666c61736b2d3030303030303f7374796c653d666f722d7468652d6261646765266c6f676f3d666c61736b266c6f676f436f6c6f723d7768697465";
        String awsUrl = "https://camo.githubusercontent.com/02f7bdf7a033321ebcb65275c6d73b5750c178c8ab3bf2c8fecec81e847be484/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616d617a6f6e6177732d3233324633453f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e617773266c6f676f436f6c6f723d7768697465";
        String dockerUrl = "https://camo.githubusercontent.com/8396abd667a0eca7d28cdb29ec63b6bf29a7854c7c3d467e6ece648c7e9b81e1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f646f636b65722d2532333064623765642e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d646f636b6572266c6f676f436f6c6f723d7768697465";
        String githubActionsUrl = "https://camo.githubusercontent.com/60f7a4c410c90351f91c96b1db36257342c0615fb0e5d827eda88ce75134c104/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f676974687562253230616374696f6e732d2532333236373145352e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d676974687562616374696f6e73266c6f676f436f6c6f723d7768697465";
        String gitUrl = "https://camo.githubusercontent.com/3d768e26ac10ba994a60ed19acd487895cc43a9cdd43e9305c2408b93136234d/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769742d2532334630353033332e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d676974266c6f676f436f6c6f723d7768697465";
        String githubUrl = "https://camo.githubusercontent.com/410d86e43f847d3f6e3027fa6f0c2fb7641d893fa601d863a943eac968c41890/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769746875622d2532333132313031312e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d676974687562266c6f676f436f6c6f723d7768697465";
        String htmlUrl = "https://camo.githubusercontent.com/5e7e215d9ff3a7c2e96d09232c11b2205565c841d1129dd2185ebd967284121f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f68746d6c352d2532334533344632362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d68746d6c35266c6f676f436f6c6f723d7768697465";
        String linuxUrl = "https://camo.githubusercontent.com/7eefb2ba052806d8a9ce69863c2eeb3b03cd5935ead7bd2e9245ae2e705a1adf/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c696e75782d4643433632343f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e7578266c6f676f436f6c6f723d626c61636b";
        String ubuntuUrl = "https://camo.githubusercontent.com/b51b672b44d8445dbcc388e0beb6122800b2620264b029c1d0d985f94f6e9732/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5562756e74752d4539353432303f7374796c653d666f722d7468652d6261646765266c6f676f3d7562756e7475266c6f676f436f6c6f723d7768697465";

        ubuntu = Stack.builder()
                .name("Ubuntu")
                .imageUrl(ubuntuUrl)
                .selected(false)
                .build();
        stackService.register(ubuntu);

        hibernate = Stack.builder()
                .name("Hibernate")
                .imageUrl(hibernateUrl)
                .selected(false)
                .build();
        stackService.register(hibernate);

        thymeleaf = Stack.builder()
                .name("Thymeleaf")
                .imageUrl(thymeleafUrl)
                .selected(false)
                .build();
        stackService.register(thymeleaf);

        python = Stack.builder()
                .name("Python")
                .imageUrl(pythonUrl)
                .selected(false)
                .build();
        stackService.register(python);

        cpp = Stack.builder()
                .name("Cpp")
                .imageUrl(cppUrl)
                .selected(false)
                .build();
        stackService.register(cpp);

        aws = Stack.builder()
                .name("Aws")
                .imageUrl(awsUrl)
                .selected(false)
                .build();
        stackService.register(aws);

        docker = Stack.builder()
                .name("Docker")
                .imageUrl(dockerUrl)
                .selected(false)
                .build();
        stackService.register(docker);

        githubActions = Stack.builder()
                .name("GithubActions")
                .imageUrl(githubActionsUrl)
                .selected(false)
                .build();
        stackService.register(githubActions);

        git = Stack.builder()
                .name("Git")
                .imageUrl(gitUrl)
                .selected(false)
                .build();
        stackService.register(git);

        github = Stack.builder()
                .name("Github")
                .imageUrl(githubUrl)
                .selected(false)
                .build();
        stackService.register(github);

        html = Stack.builder()
                .name("Html")
                .imageUrl(htmlUrl)
                .selected(false)
                .build();
        stackService.register(html);

        linux = Stack.builder()
                .name("Linux")
                .imageUrl(linuxUrl)
                .selected(false)
                .build();
        stackService.register(linux);


        //

        spring = Stack.builder()
                .name("Spring")
                .imageUrl(springUrl)
                .selected(false)
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
}
