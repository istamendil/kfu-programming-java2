package info.istamendil.notebook.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *
 * Implementation db with storing objects on hard drive.
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 *
 * Code for studying purposes. Programming course. Kazan Federal
 * University, ITIS. http://study.istamendil.info/
 */
public class FileDb implements Db {

    protected final String path;
    private Object[] dataDb;

    public FileDb(String path) {
        this.dataDb = new Object[0];
        this.path = path;
    }

    @Override
    public void save(Object obj) throws DbException {
        Object[] data = this.findAll();
        Object[] newData = new Object[data.length + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[newData.length - 1] = obj;
        this.dataDb = newData;
        /*try (FileOutputStream stream = new FileOutputStream(this.path)) {
            Object[] newData = new Object[data.length + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            newData[newData.length - 1] = obj;
            stream.write(this.convertToBytes(newData));
        } catch (IOException ex) {
            throw new DbException("DB error: " + ex.getMessage());
        }*/
    }
    
    @Override
    public Object[] findAll() throws DbException {
        if(this.dataDb.length > 0){
            return this.dataDb;
        }else{
            return new Object[0];
        }
        /*try {
            Path path = Paths.get(this.path);
            byte[] data = Files.readAllBytes(path);
            if (data.length > 0) {
                return (Object[]) this.convertFromBytes(data);
            }
            else {
                return new Object[0];
            }
        } catch (IOException ex) {
            throw new DbException("DB error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new DbException("DB error: " + ex.getMessage());
        }*/
    }

    private byte[] convertToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    private Object convertFromBytes(byte[] data) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
                ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }

}
