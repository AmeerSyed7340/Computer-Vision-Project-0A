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

        //Step 1:
        try{
            Scanner scanner = new Scanner(inFile);
            FileWriter fw_outFile1 = new FileWriter(outFile1);
            FileWriter fw_outFile2 = new FileWriter(outFile2);

            if(scanner.hasNextLine()){
                scanner.nextLine();
            }//set the scanner to start from line 2

            //Step 3:
            while(scanner.hasNext()){
                pixelVal = scanner.nextInt();

                //Step 2:
                for(int i = 0; i < this.numRows; i++){
                    for(int j = 0; j < this.numCols; j++){
                        if(pixelVal >= thrValue){
                            fw_outFile1.write(1 + " ");
                            fw_outFile2.write(pixelVal + " ");
                        }
                        else {
                            fw_outFile1.write(0 + " ");
                            fw_outFile2.write(0 + " ");
                        }
                    }
                    fw_outFile1.write("\n");
                    fw_outFile2.write("\n");
                }
            }//while end

            //close all files
            scanner.close();
            fw_outFile1.close();
            fw_outFile2.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
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
        File infile = new File("./src/input.txt");
        File outFile1 = new File("./src/outFile1.txt");
        File outFile2 = new File("./src/outFile2.txt");

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
            thrValue = in.nextInt();

            //close threshold scanner bc it is no longer needed
            in.close();

           //Step 1:
            fileWriter_outFile1.write("numRows: " + numRows + ", " + "numCols: " + numCols + ", " + "minVal: " + minVal + ", " + "maxVal: " + maxVal + "\n");
            fileWriter_outFile2.write("numRows: " + numRows + ", " + "numCols: " + numCols + ", " + "minVal: " + minVal + ", " + "maxVal: " + maxVal + "\n");

            //Step 2:
            Image img = new Image(numRows, numCols, minVal, maxVal, thrValue);
            img.processing(infile, outFile1, outFile2, thrValue);
            //close files
            scanner.close();
            fileWriter_outFile1.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }//main
}//Practice class (Main)
