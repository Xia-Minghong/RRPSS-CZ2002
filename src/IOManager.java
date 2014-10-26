import java.io.*;

/**
 * A IOManager handles the file read/write in the RRPSS system
 * to achieve data persistence.
 */
public class IOManager {
    /**
     * the default file path & name for the Read/Write
     */
    private static final String FILE_PATH = "RRPSS.dat";

    /**
     * No-arg read method to use the default path for reading
     * @return the deserialized object of class Object or null if the method fails
     */
    public Object read() {
        return read(FILE_PATH);
    }

    /**
     * Read method with a given path
     * @param filePath the file path to the file from which the data will be read
     * @return the deserialized object of class Object or null if the method fails
     */
    public Object read(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object obj = objectInputStream.readObject();    //reading

            objectInputStream.close();
            fileInputStream.close();
            return obj;
        } catch(IOException i) {    //handle IO exceptions
            i.printStackTrace();
            return null;
        } catch(ClassNotFoundException c) {     //handle ClassNotFound exception from the readObject()
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
        }
    }

    /**
     * Write method to use the default path for writing
     * @param object the object to be written
     * @return true if the write method is successful or false if otherwise
     */
    public boolean write(Table object) {
        return write(object, FILE_PATH);
    }

    /**
     * Write method with a given path and a object
     * @param object the object to be written
     * @param filePath the file path to write to
     * @return true if the write method is successful or false if otherwise
     */
    public boolean write(Table object, String filePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object); //writing

            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Serialized data is stored in \""+filePath+"\"");
            return true;
        }catch(IOException i) { //handle the IO exception
            i.printStackTrace();
            return false;
        }
    }

    //test
    public static void main(String[] args) {
//        Table table = new Table(1, 2);
        IOManager ioManager = new IOManager();
//        ioManager.write(table);
        Table anotherTable = (Table)ioManager.read();
        System.out.println("\ncapacity"+anotherTable.getCAPACITY());
        System.out.println("ID"+anotherTable.getTABLE_ID());
        System.out.println("present"+anotherTable.isPresence());
    }
}