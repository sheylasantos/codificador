import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Entity implements Serializable{
    public Entity(){}

    public abstract String fileName();

    private boolean saveFile(){
        try {
            FileOutputStream f = new FileOutputStream(new File(this.fileName()));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);

        }catch (FileNotFoundException e){
            System.out.println("File not found");
            return false;
        }catch (IOException e) {
            System.out.println("Error initializing stream");
            return false;

        }
        return true;
    }
    public abstract boolean validar();

    public boolean salvar(){
        if (validar()){
            return saveFile();
        }
        return false;
    }


}
