package WechatMiniProject.LianYi.Implement;

import WechatMiniProject.LianYi.Constant.QuestionConstant;
import WechatMiniProject.LianYi.Model.QuestionEntity;
import WechatMiniProject.LianYi.Repository.QuestionDao;
import WechatMiniProject.LianYi.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class getQuestionImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<QuestionEntity> getQuestions() {
        List<QuestionEntity> battleQuestions =  questionDao.findQuestion();
        List<QuestionEntity> questionsReturn = new ArrayList<>();
        if (battleQuestions.size() <= QuestionConstant.QUESTION_NUMBER) return battleQuestions;
        while(questionsReturn.size()<QuestionConstant.QUESTION_NUMBER){
            int id = (int)(Math.random()*(battleQuestions.size()));
            boolean tag = false;
            for (QuestionEntity entity : questionsReturn){
                if (entity.getQuestionId() == id+1){
                    tag = true;
                    break;
                }
            }
            if(!tag){
                questionsReturn.add(battleQuestions.get(id));
            }
        }
        return questionsReturn;
    }
}

