import java.io.ObjectOutputStream;

/**
* File: Lab11Prob01
* Class: CSCI 1302
* Author: Christopher Williams
* Created on: Jun 6, 2016
* Last Modified: Aug 16, 2018
* Description: Display three messages to the console
*/

import java.io.*;

public class Lab11Prob01 {
    public static void main(String[] args){

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/people.dat"));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/people-copy.dat"));
        ){
            while ((input.read()) != -1){
                output.writeInt(input.readInt());
                output.writeUTF(input.readUTF());
                output.writeUTF(input.readUTF());
                output.writeInt(input.readInt());
                output.writeDouble(input.readDouble());
            }
        } catch (IOException e) {
    
        }
    }
}
