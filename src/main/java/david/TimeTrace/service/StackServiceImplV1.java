package david.TimeTrace.service;

import david.TimeTrace.domain.Stack;
import david.TimeTrace.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StackServiceImplV1 implements StackService
{
    private final StackRepository stackRepository;

    @Transactional
    @Override
    public Stack register(Stack stack)
    {
        return stackRepository.save(stack);
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

    @Transactional
    @Override
    public void clearAll()
    {
        stackRepository.clearAll();
    }
}
