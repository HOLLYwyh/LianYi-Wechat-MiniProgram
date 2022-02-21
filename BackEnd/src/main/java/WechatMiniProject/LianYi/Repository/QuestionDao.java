package WechatMiniProject.LianYi.Repository;

import WechatMiniProject.LianYi.Model.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity, Integer>{
    @Query("select sb from QuestionEntity sb")
    List<QuestionEntity> findQuestion();
}
