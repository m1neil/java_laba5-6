import javax.swing.*;
import java.io.*;

public class Notepad {
    private File currentFile;

    File newFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(null);
        File file = new File(fileChooser.getSelectedFile().getPath());
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    void saveFile(byte[] data) {
        try {
            if (currentFile != null) {
                currentFile.delete();
                currentFile.createNewFile();
            } else
                currentFile = newFile();

            FileOutputStream stream = new FileOutputStream(currentFile);
            stream.write(data);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    byte[] openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        currentFile = fileChooser.getSelectedFile();
        long lengthFile = currentFile.length();
        byte[] fileBytes = new byte[(int) lengthFile];
        try {
            FileInputStream stream = new FileInputStream(currentFile);
            stream.read(fileBytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }
    public File getCurrentFile() {
        return currentFile;
    }
}