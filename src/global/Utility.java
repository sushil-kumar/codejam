package global;

import java.io.BufferedWriter;
import java.io.IOException;

public class Utility {
	public static void writeResult(BufferedWriter writer, int caseNo, String result) 
            throws IOException {
        writer.write("Case #" + caseNo + ": " + result + "\n");
    }
}
