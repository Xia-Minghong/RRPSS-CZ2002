package control;

import java.io.*;
import java.util.ArrayList;

/**
 * A abstract orderManager containing necessary attributes and methods to achieve data persistence.
 *
 * @author Xia Minghong
 * @version 1.0
 * @since 2014-10-24.
 */
public abstract class AbstractManager {
    /**
     * the default file path for the Read/Write
     * when no file path is given
     */
    private final String FILE_PATH;

    /**
     * Constructor of the AbstractManager class
     * @param FILE_PATH the file path from which object will be read and to which the object will be written
     */
    public AbstractManager(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

//    /**
//     * No-arg read method to use the default path for reading
//     * @return the deserialized object of class Object or null if the method fails
//     */
//    public Object read() {
//        return read(FILE_PATH);
//    }

    /**
     * Read method with a given path
     * @return the deserialized object of class Object or null if the method fails
     */
    public Object read() {
        try {
            //Create Stream Objects
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //read
            Object obj = objectInputStream.readObject();

            //Close the streams
            objectInputStream.close();
            fileInputStream.close();

            return obj;
        } catch (FileNotFoundException i) {    //return null if file is not fount
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {     //handle ClassNotFound exception from the readObject()
            System.out.println("Class not be found.");
            return null;
        }
    }

//    /**
//     * Write method to use the default path for writing
//     * @param object the object to be written
//     * @return true if the write method is successful or false if otherwise
//     */
//    public static boolean write(Serializable object) {
//        return write(object, FILE_PATH);
//    }

    /**
     * Write method with a given path and a object
     * @param object the object to be written
     * @return true if the write method is successful or false if otherwise
     */
    public boolean write(Serializable object) {
        try {
            //Create Stream Objects
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //Write
            objectOutputStream.writeObject(object); //writing

            //Close the streams
            objectOutputStream.close();
            fileOutputStream.close();

            //used for debug purpose
//            System.out.println("Serialized data is stored in \""+FILE_PATH+"\"");
            return true;
        }catch(IOException i) { //handle the IO exception
            System.out.println("Error writing file");
            return false;
        }
    }

    /**
     * An abstract method to guarantee that each manager that needs to achieve data persistence
     * will implement a customized load method
     * @return the raw object read from the file
     */
    public abstract Object load();

    /**
     * An abstract method to guarantee that each manager that needs to achieve data persistence
     * will implement a customized save method
     */
    public abstract void save();



    //test
//    public static void main(String[] args) {
////        entity.Table table = new entity.Table(1, 2);
//        IOManager ioManager = new IOManager();
////        ioManager.write(table);
//        Table anotherTable = (Table)ioManager.read();
//        System.out.println("\ncapacity"+anotherTable.getCAPACITY());
//        System.out.println("ID"+anotherTable.getTABLE_ID());
//        System.out.println("present"+anotherTable.isPresence());
//    }
}
