package david.TimeTrace.service;

import david.TimeTrace.domain.Stack;
import david.TimeTrace.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class StackServiceImplV1 implements StackService
{
    private final StackRepository stackRepository;

    @Override
    public Stack register(Stack stack)
    {
        return stackRepository.save(stack);
    }

    @Override
    public void addMyStack(List<String> addStacks)
    {
        if (addStacks != null)
        {
            for (String stackName : addStacks)
            {
                Optional<Stack> stack = stackRepository.findByName(stackName);
                stack.ifPresent(Stack::select);
            }
        }
    }

    @Override
    public void removeMyStack(List<String> removeStacks)
    {
        if (removeStacks != null)
        {
            for (String stackName : removeStacks)
            {
                Optional<Stack> stack = stackRepository.findByName(stackName);
                stack.ifPresent(Stack::unselect);
            }
        }
    }

    @Override
    public Optional<Stack> findStackByName(String stackName)
    {
        return stackRepository.findByName(stackName);
    }

    @Override
    public List<String> findSelectedStackNames()
    {
        return stackRepository.findSelectedNames();
    }

    @Override
    public List<String> findSelectedStackUrls()
    {
        return stackRepository.findSelectedImageUrls();
    }

    @Override
    public List<String> findUnselectedStackNames()
    {
        return stackRepository.findUnselectedNames();
    }

    @Override
    public void clearAll()
    {
        stackRepository.clearAll();
    }
}
