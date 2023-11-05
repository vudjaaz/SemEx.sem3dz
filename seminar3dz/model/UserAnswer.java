package seminar3dz.model;

public class UserAnswer {

    private String answer;

    public UserAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserAnswer [answer=" + answer + "]";
    }

    
    
}
