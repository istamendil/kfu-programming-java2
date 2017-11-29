package info.istamendil.notebook.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * Implementation of UserInteractor with reading command from file ("punched card").
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 *
 * Code for studying purposes. Programming course. Kazan Federal
 * University, ITIS. http://study.istamendil.info/
 */
public abstract class AbstractUserInteractor implements UserInteractor {

    @Override
    public void print(String output) throws UserInteractorWriteException {
        System.out.println(">> " + output);
    }

}
