package david.TimeTrace.service;

import david.TimeTrace.domain.Stack;

import java.util.List;

public interface StackService
{
    public Stack register(Stack stack);

    public List<String> findSelectedStackNames();

    public List<String> findSelectedStackUrls();

    public List<String> findUnselectedStackNames();

    public void clearAll();
}
