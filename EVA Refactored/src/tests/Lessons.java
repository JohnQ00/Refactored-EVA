package tests;

public class Lessons {
    private int qIndex = 0;
    private int aIndex = 0;
    private String questions[] = new String[100];
    private String alternatives[] = new String[5];
    private String leadingCourse;
    private String lessonAnswer;
    private int numberofQuestions;
    private boolean answered = false;

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public String[] getQuestions() {
        return questions;
    }

    public String[] getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives[aIndex] = alternatives;
        aIndex++;
    }

    public void setQuestions(String questions) {
        this.questions[qIndex] = questions;
        qIndex++;
    }

    public String getLessonAnswer() {
        return lessonAnswer;
    }

    public void setLessonAnswer(String lessonAnswer) {
        this.lessonAnswer = lessonAnswer;
    }

    public int getNumberofQuestions() {
        return numberofQuestions;
    }

    public void setNumberofQuestions(int numberofQuestions) {
        this.numberofQuestions = numberofQuestions;
    }

    public String getLeadingCourse() {
        return leadingCourse;
    }

    public void setLeadingCourse(String leadingCourse) {
        this.leadingCourse = leadingCourse;
    }
}
