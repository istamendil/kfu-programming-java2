package info.istamendil.notebook.utils;

import java.util.Scanner;

public class RAMInteractor implements UserInteractor {

    protected final String[] lines;
    protected int currentLine = 0;

    public RAMInteractor() throws UserInteractorException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("/")) {
            throw new UserInteractorException("Nothing to input");
        }
        String[] lines = {line};
        while (!line.equals("/")) {  // enter "/" for the end of the input
            String[] lines1 = new String[lines.length + 1];
            for (int i = 0; i < lines.length; i++) {
                lines1[i] = lines[i];
            }
            lines1[lines.length] = line;
            lines = lines1.clone();
            line = scanner.nextLine();
        }
        this.lines = lines.clone();
        this.currentLine = 0;
    }

    @Override
    public String readCommand() throws UserInteractorReadException {
        String command = null;
        if(this.currentLine < this.lines.length){
            command = this.lines[this.currentLine];
            this.currentLine++;
            System.out.println("<< " + command);
        }
        return command;
    }

    @Override
    public void print(String output) throws UserInteractorWriteException {
        System.out.println(">> " + output);
    }
}
