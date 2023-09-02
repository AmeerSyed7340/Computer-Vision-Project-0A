import java.util.*;
import java.io.*;
class Image{
    int numRows;
    int numCols;
    int minVal;
    int maxVal;
    int thrValue;

    public Image(int numRows, int numCols, int minVal, int maxVal, int thrValue){
        this.numRows = numRows;
        this.numCols = numCols;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.thrValue = thrValue;
    }//constructor

    //methods
    void processing(File inFile, File outFile1, File outFile2, int thrValue){
        //Step 0:
        int pixelVal;
        int count = 0;

        //Step 1:
        try{
            Scanner scanner = new Scanner(inFile);
            FileWriter fw_outFile1 = new FileWriter(outFile1, true);
            FileWriter fw_outFile2 = new FileWriter(outFile2, true);

            if(scanner.hasNextLine()){
                scanner.nextLine();
            }//set the scanner to start from line 2

            // Step 3:
            while (scanner.hasNext()) {
                pixelVal = scanner.nextInt();
                if(pixelVal >= thrValue){
                    fw_outFile1.write(1 + " ");
                    fw_outFile2.write(pixelVal + " ");
                }
                else {
                    fw_outFile1.write(0 + " ");
                    fw_outFile2.write(0 + " ");
                }
                count++;
                if(count == this.numCols){
                    fw_outFile1.write("\n");
                    fw_outFile2.write("\n");
                    count = 0;
                }
            }//while end

            //close all files
            scanner.close();
            fw_outFile1.close();
            fw_outFile2.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }//processing
}//Image
public class Practice {
    public static void main(String[] args) {
        //vars to pass into the constructor
        int numRows = 0;
        int numCols = 0;
        int minVal = 0;
        int maxVal = 0;

        //var to pass in using Input
        int thrValue;

        //Step 0:
        File infile = new File(args[0]);
        File outFile1 = new File(args[1]);
        File outFile2 = new File(args[2]);

        try{
            Scanner scanner =  new Scanner(infile);
            Scanner in = new Scanner(System.in);

            FileWriter fileWriter_outFile1 = new FileWriter(outFile1);
            FileWriter fileWriter_outFile2 = new FileWriter(outFile2);
            if(scanner.hasNext()){
                numRows = scanner.nextInt();
                numCols = scanner.nextInt();
                minVal = scanner.nextInt();
                maxVal = scanner.nextInt();
            }
            //close the scanner needed for first line
            scanner.close();

            //get threshold from user
            System.out.println("Please enter the threshold value:");
            thrValue = in.nextInt();

            //close threshold scanner bc it is no longer needed
            in.close();

            //Step 1:
            fileWriter_outFile1.write(numRows + " " + numCols + " " + minVal + " " + maxVal + "\n");
            fileWriter_outFile2.write(numRows + " " + numCols + " " + minVal + " " + maxVal + "\n");

            //close filewriters
            fileWriter_outFile1.close();
            fileWriter_outFile2.close();

            //Step 2:
            Image img = new Image(numRows, numCols, minVal, maxVal, thrValue);
            img.processing(infile, outFile1, outFile2, thrValue);

            //close files
            scanner.close();

        } catch (IOException e){
            System.out.println(e);
        }
    }//main
}//Practice class (Main)
