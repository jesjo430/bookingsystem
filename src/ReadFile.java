import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads files.
 */

public class ReadFile
{
    /**
     * Reads data from files.
     * @param fileName must be a string that exists in project folder.
     * @return a string with data from loaded file.
     */
    public String readFiles(final String fileName) throws IOException {
	System.out.println("READ: " + fileName);
	File file = new File(fileName);
	try {
	    FileReader fileReader = new FileReader(file);

	    StringBuilder stringBuffer = new StringBuilder();
	    int numCharsRead;
	    int charSize = 2^10;
	    char[] charArray = new char[charSize];
	    numCharsRead = fileReader.read(charArray);
	    while (numCharsRead > 0) {
		stringBuffer.append(charArray, 0, numCharsRead);
		numCharsRead = fileReader.read(charArray);
	    }
	    fileReader.close();
	    return stringBuffer.toString();
	}
	catch (IOException e) {
	    e.printStackTrace();
	}
	throw new IOException("Could not read file" + fileName +".");
    }
}
