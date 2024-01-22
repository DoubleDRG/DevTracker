package david.TimeTrace.repository;

import david.TimeTrace.domain.Stack;

import java.util.List;
import java.util.Optional;

public interface StackRepository
{
    //==새로운 기술스택 저장==//
    public Stack save(Stack techStack);

    //==모든 스택 조회==//
    public List<Stack> findAll();

    //==스택 이름으로 스택 조회==//
    public Optional<Stack> findByName(String stackName);

    //==스택이름으로 스택이미지 Url 반환==//
    public Optional<String> findImageUrlByName(String stackName);

    //==선택한 기술스택 이름 보여주기==//
    public List<String> findSelectedName();

    //==선택한 기술스택 이미지 Url 보여주기==//
    public List<String> findSelectedImageUrls();

    //==선택하지 않은 기술스택 이름 보여주기==//
    public List<String> findUnselectedName();

    //==선택하지 않은 기술스택 이미지 Url 보여주기==//
    public List<String> findUnselectedImageUrls();

    //==모든 데이터 삭제==//
    public void clearAll();
}
