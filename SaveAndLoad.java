import java.io.FileWriter;
import java.io.IOException;

public class SaveAndLoad {

    public void Save() {
        try {
            FileWriter MyFileWriter = new FileWriter("Savedata.txt");
            MyFileWriter.write("Fuck this shit");
            System.out.println("Save succes");
            MyFileWriter.close();
        } catch (IOException e) {
            System.out.println("An error has occured while saving");
            e.printStackTrace();
        }
    }
}
