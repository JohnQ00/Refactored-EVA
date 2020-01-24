package command;

import user.User;

import java.util.ArrayList;

public interface Command {
    // Controla cada entrada de funcionalidade através de uma interface única comum a todos evitando o uso de if's.
    public void execute(ArrayList<User> users, int userId, Option optionName);
}
