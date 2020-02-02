package tests;

import user.User;

import java.util.ArrayList;

public interface Factory {
    void execute(ArrayList<User> users, int userId); //TODO essa gera o metodo de execucao/criacao que a factoryAlgumaCoisa carrega, retornando a instancia do objeto desejado
}
