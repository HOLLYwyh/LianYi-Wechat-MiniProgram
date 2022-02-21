package WechatMiniProject.LianYi.Model;

import javax.persistence.*;

@Entity
@Table(name = "question", schema = "LianYi", catalog = "")
public class QuestionEntity {
    private int questionId;
    private String title;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;

    @Id
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 256)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "answer_A", nullable = true, length = 2)
    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    @Basic
    @Column(name = "answer_B", nullable = true, length = 2)
    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    @Basic
    @Column(name = "answer_C", nullable = true, length = 2)
    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    @Basic
    @Column(name = "answer_D", nullable = true, length = 2)
    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    @Basic
    @Column(name = "correct_answer", nullable = true, length = 2)
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (questionId != that.questionId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (answerA != null ? !answerA.equals(that.answerA) : that.answerA != null) return false;
        if (answerB != null ? !answerB.equals(that.answerB) : that.answerB != null) return false;
        if (answerC != null ? !answerC.equals(that.answerC) : that.answerC != null) return false;
        if (answerD != null ? !answerD.equals(that.answerD) : that.answerD != null) return false;
        if (correctAnswer != null ? !correctAnswer.equals(that.correctAnswer) : that.correctAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (answerA != null ? answerA.hashCode() : 0);
        result = 31 * result + (answerB != null ? answerB.hashCode() : 0);
        result = 31 * result + (answerC != null ? answerC.hashCode() : 0);
        result = 31 * result + (answerD != null ? answerD.hashCode() : 0);
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        return result;
    }
}
