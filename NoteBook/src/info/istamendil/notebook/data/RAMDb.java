package info.istamendil.notebook.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implementation db with storing objects on RAM.
 * @author Boris Kozhyhovskiy (borisgk98) <borisgk98@ya.ru>
 *
 * Code for studying purposes. Programming course. Kazan Federal
 * University, ITIS. http://study.istamendil.info/
 */
public class RAMDb extends AbstractDb implements Db {
        List data;

        public RAMDb() {
            this.data = new ArrayList();
        }

        @Override
        public void save(Object obj) throws DbException {
            try {
                data.add(obj);
            }
            catch (Exception ex) {
                throw  new DbException("DB error: " + ex.getMessage());
            }
        }

        @Override
        public Object[] findAll() throws DbException {
            try {
                return data.toArray();
            }
            catch (Exception ex) {
                throw  new DbException("DB error: " + ex.getMessage());
            }
        }
}
