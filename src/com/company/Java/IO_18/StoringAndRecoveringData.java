package com.company.Java.IO_18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData {
  public static void main(String[] args) throws IOException {
    DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(new FileOutputStream("./src/com/company/IO_18/Data.txt"))
    );
    out.writeDouble(1.234);
    out.writeUTF("this is a utf");
    out.close();

    DataInputStream in = new DataInputStream(
        new BufferedInputStream(new FileInputStream("Data.txt"))
    );

    System.out.println(in.readDouble());
    System.out.println(in.readUTF());
  }
}
