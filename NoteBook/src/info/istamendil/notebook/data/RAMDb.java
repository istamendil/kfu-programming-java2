package info.istamendil.notebook.data;

public class RAMDb implements Db {

    protected String[] text;

    public RAMDb() {
        this.text = new String[0];
    }

    @Override
    public void save(Object obj) throws DbException {
        String[] text1 = new String[this.text.length + 1];
        for (int i = 0; i < this.text.length; i++) {
            text1[i] = this.text[i];
        }
        text1[this.text.length] = (String) obj;
        this.text = text1.clone();
    }

    @Override
    public Object[] findAll() throws DbException {
        return (Object[]) this.text;
    }
}
