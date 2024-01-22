package david.TimeTrace.service;

import david.TimeTrace.domain.Stack;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StackService
{
    public Stack register(Stack stack);

    public void addMyStack(List<String> addStacks);

    public void removeMyStack(List<String> removeStacks);

    public Optional<Stack> findStackByName(String stackName);
    public List<String> findSelectedStackNames();

    public List<String> findSelectedStackUrls();

    public List<String> findUnselectedStackNames();

    public void clearAll();
}
