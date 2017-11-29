package info.istamendil.notebook.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Implementation of UserInteractor with reading command from console.
 * @author Boris Kozhyhovskiy (borisgk98) <borisgk98@ya.ru>
 *
 * Code for studying purposes. Programming course. Kazan Federal
 * University, ITIS. http://study.istamendil.info/
 */
public class ConsoleUserInteractor extends AbstractUserInteractor  implements UserInteractor {

    public ConsoleUserInteractor() throws UserInteractorException  { }

    @Override
    public String readCommand() throws UserInteractorReadException {
        String command = null;
        try {
            Scanner scan = new Scanner(System.in);
            command = scan.nextLine();
        }
        catch (Exception ex) {
            throw new UserInteractorReadException("Read error: " + ex.getMessage());
        }
        return command;
    }

}
