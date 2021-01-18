package filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class TXTFilter extends FileFilter {
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            return extension.equals(Utils.txt);
        }

        return false;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
