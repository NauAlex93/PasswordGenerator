package passwordgenerator;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Generator {
    
    static ArrayList<ByteArrayOutputStream> baosList = new ArrayList<>();
    
    public ByteArrayOutputStream getPassword() {
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        boolean numb = false;
        boolean upper = false;
        boolean lower = false;
        
        while (baos.size() != 8) {
            int k = (int) (1 + Math.random() * 3);
            
            if (k == 1) {
                baos.write((int) (48 + Math.random() * 10));
                numb = true;
            }
            
            if (k == 2) {
                baos.write((int) (65 + Math.random() * 26));
                upper = true;
            }
            
            if (k == 3) {
                baos.write((int) (97 + Math.random() * 26));
                lower = true;
            }
        }
        
        if ((numb && upper && lower) && !baosList.contains(baos)) {
            baosList.add(baos);
            return baos;
        } else
            return getPassword();
    }
    
    
}
