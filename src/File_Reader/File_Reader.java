package File_Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class File_Reader {
        /**
         * This method reads a file from the path that it was passed and prints the data in System.out.println statements
         * @param fileName 
         */
        public static void readFilePrint(String fileName)
        {
             BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(fileName));
 
			while ((sCurrentLine = br.readLine()) != null) 
                        {
				System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
                                br.close();
                            }
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
        }
        /**
         *  This Method reads the file that the path of the file is passed
         * @param fileName
         * @return A arraylist<String> type that contains the data
         */
        public static ArrayList<String> readFileReturnArrayList(String fileName)
        {
              ArrayList<String> data = new ArrayList<>();
              BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(fileName));
 
			while ((sCurrentLine = br.readLine()) != null) 
                        {
				data.add(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
                                br.close();
                            }
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
             return data;
        }
    }