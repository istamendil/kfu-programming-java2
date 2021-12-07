package info.istamendil.notebook;

import info.istamendil.notebook.data.Db;
import info.istamendil.notebook.data.DbException;
import info.istamendil.notebook.data.FileDb;
import info.istamendil.notebook.utils.UserInteractor;
import info.istamendil.notebook.utils.PunchedCardUserInteractor;
import info.istamendil.notebook.utils.UserInteractorException;
import info.istamendil.notebook.utils.UserInteractorReadException;
import info.istamendil.notebook.utils.UserInteractorWriteException;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *
 * Note Book. UserInteractor and DB modules.
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 *
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public class App extends Application{

    private static final String DB = "C:\\Users\\ICL\\Desktop\\data\\db.txt";
    private static final String PUNCH_CARD = "C:\\Users\\ICL\\Desktop\\data\\card.txt";

    protected UserInteractor terminal;
    protected Db db;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App(args);
    }

    public App(String[] args) {
        super(args);
    }

    @Override
    public void init() {
        try {
            this.terminal = new PunchedCardUserInteractor();
            this.db = new FileDb(App.DB);
        } catch (UserInteractorException ex) {
            System.out.println("Couldn't start application due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void start() {
        try {
            String command;
            while((command = this.terminal.readCommand()) != null){
                switch(command){
                    case "readAll":
                        this.terminal.print(Arrays.toString(this.db.findAll()));
                        break;
                    case "save":
                        if((command = this.terminal.readCommand()) != null){
                            this.db.save(command);
                        }
                        break;
                    default:
                        this.terminal.print("Unknown command");
                }
            }
        } catch (UserInteractorReadException ex) {
            System.out.println("Can't read user input due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (UserInteractorWriteException ex) {
            System.out.println("Can't print data to user due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (DbException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

}
