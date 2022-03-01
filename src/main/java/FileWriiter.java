import java.io.FileWriter;

public class FileWriiter {

    public void fisier(String str, String str2) {
        try {
            FileWriter myWriter = new FileWriter(str);
            myWriter.write(str2);
            myWriter.close();
        } catch (Exception ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }
}
