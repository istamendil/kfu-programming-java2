package info.istamendil.notebook.utils;
import java.util.Scanner;

public class UserReadCommandInteractor implements UserInteractor {

    @Override
    public String readCommand() throws UserInteractorReadException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input next command: ");
        String command = sc.nextLine();
        return command;
    }

    @Override
    public void print(String output) throws UserInteractorWriteException {
        System.out.println(">> " + output);
    }
}
