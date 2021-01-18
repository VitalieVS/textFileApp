package options;

import models.ListInterface;
import models.TXTFileModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TXTFileReader implements ListInterface {
    File file;

    public TXTFileReader(File file) {
        this.file = file;
    }

    public void readFile() {
        try {
            Scanner scanner = new Scanner(new File(String.valueOf(this.file)));
            while (scanner.hasNextLine()) {
                String[] array = scanner.nextLine().split(" ");
                TXTFileModel foo = new TXTFileModel(array);
                textFileList.add(foo);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
