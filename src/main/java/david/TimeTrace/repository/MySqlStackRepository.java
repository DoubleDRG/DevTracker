package david.TimeTrace.repository;

import david.TimeTrace.domain.Stack;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MySqlStackRepository implements StackRepository
{
    private final EntityManager entityManager;

    //==새로운 기술스택 저장==//
    @Override
    public Stack save(Stack techStack)
    {
        entityManager.persist(techStack);
        String query = "select s from Stack s where s.name = " + techStack.getName();
        return entityManager.createQuery(query, Stack.class).getSingleResult();
    }

    //==기술스택 이름으로 조회==//
    @Override
    public Optional<Stack> findByName(String stackName)
    {
        String query = "select s from Stack s where s.name =" + stackName;
        return entityManager.createQuery(query, Stack.class).getResultList().stream().findAny();
    }

    //==기술스택 이름으로 이미지Url 조회==//
    @Override
    public String findImageUrlByName(String stackName)
    {
        String query = "select s.imageUrl from Stack s where s.name = " + stackName;
        return entityManager.createQuery(query, String.class).getSingleResult();
    }

    @Override
    public List<String> findSelectedName()
    {
        return null;
    }

    @Override
    public List<String> findSelectedImageUrls()
    {
        return null;
    }

    @Override
    public List<String> findUnselectedName()
    {
        return null;
    }

    @Override
    public List<String> findUnselectedImageUrls()
    {
        return null;
    }
}
