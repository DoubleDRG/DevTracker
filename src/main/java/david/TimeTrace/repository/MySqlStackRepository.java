package david.TimeTrace.repository;

import david.TimeTrace.domain.Stack;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
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
        return techStack;
    }
    
    //==모든 스택 조회==//
    @Override
    public List<Stack> findAll()
    {
        String query = "select s from Stack s";
        return entityManager.createQuery(query, Stack.class).getResultList();
    }

    //==기술스택 이름으로 조회==//
    @Override
    public Optional<Stack> findByName(String stackName)
    {
        String query = "select s from Stack s where s.name = :stackName";
        return entityManager.createQuery(query, Stack.class)
                .setParameter("stackName",stackName)
                .getResultList()
                .stream()
                .findAny();
    }

    //==기술스택 이름으로 이미지Url 조회==//
    @Override
    public Optional<String> findImageUrlByName(String stackName)
    {
        String query = "select s.imageUrl from Stack s where s.name = :stackName";
        return entityManager.createQuery(query, String.class)
                .setParameter("stackName", stackName)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public List<String> findSelectedNames()
    {
        String query = "select s.name from Stack s where s.selected =:value";
        return entityManager.createQuery(query, String.class)
                .setParameter("value", true)
                .getResultList();
    }

    @Override
    public List<String> findSelectedImageUrls()
    {
        String query = "select s.imageUrl from Stack s where s.selected = :value";
        return entityManager.createQuery(query, String.class)
                .setParameter("value", true)
                .getResultList();
    }

    @Override
    public List<String> findUnselectedNames()
    {
        String query = "select s.name from Stack s where s.selected =:value";
        return entityManager.createQuery(query, String.class)
                .setParameter("value", false)
                .getResultList();
    }

    @Override
    public List<String> findUnselectedImageUrls()
    {
        String query = "select s.imageUrl from Stack s where s.selected = :value";
        return entityManager.createQuery(query, String.class)
                .setParameter("value", false)
                .getResultList();
    }

    //==모든 데이터 삭제==//
    @Override
    public void clearAll()
    {
        String query = "Delete from Stack";
        entityManager.createQuery(query).executeUpdate();
    }
}
