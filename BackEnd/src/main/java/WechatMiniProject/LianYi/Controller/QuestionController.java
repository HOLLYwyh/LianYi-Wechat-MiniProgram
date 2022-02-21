package WechatMiniProject.LianYi.Controller;

import WechatMiniProject.LianYi.Implement.getQuestionImpl;
import WechatMiniProject.LianYi.Model.QuestionEntity;
import WechatMiniProject.LianYi.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/questions")
public class QuestionController {
    // 依赖注入
    @Autowired
    QuestionService questionService;
    // 随机返回题目
    @RequestMapping(value = "getQuestion", method = RequestMethod.GET)
    public List<QuestionEntity> getBattleQuestion(){
        return questionService.getQuestions();
    }
}
