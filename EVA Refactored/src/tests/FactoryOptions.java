package tests;

import java.util.HashMap;

public class FactoryOptions {
    private HashMap<String, Factory> choiceMap = new HashMap<>();
    private void buildMap() {
        choiceMap.put("Lesson", new LessonCreation());
        choiceMap.put("Test", new TestCreation());
    }

    public Factory getOperation(String option){
        buildMap();
        return choiceMap.getOrDefault(option, new InvalidChoice());

    }
}
