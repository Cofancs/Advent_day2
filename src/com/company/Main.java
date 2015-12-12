package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int totalWrapping=0;

        try {
            FileReader input= new FileReader("C:\\WorkSpace\\Advent\\Advent_day2\\src\\com\\company\\input.txt");

            BufferedReader bufferedReader = new BufferedReader(input);
            String line =bufferedReader.readLine();
//System.out.println(line.length());
            while(line!= null){
                String[] seperated=line.split("x");

                int l,w,h;
                l= Integer.parseInt(seperated[0]);

                w= Integer.parseInt(seperated[1]);
                h= Integer.parseInt(seperated[2]);

                int area=(2*l*w)+(2*l*h)+(2*h*w);
                int min=l*w,temp=w*h,temp2=l*h;
                if(temp<min){
                    min=temp;
                    temp=temp2;
                    if(temp<min){
                        min=temp;
                    }
                }else if (temp2<min){
                    min=temp2;
                    temp2=temp;
                    if(temp2<min){
                        min=temp;
                    }
                }
                int total=area+min;
                //System.out.println(l+" "+w+" "+h+" min: "+ min+" sqr: "+total );
                totalWrapping+=total;
                line=bufferedReader.readLine();
            }
            System.out.println("total wrapping sqr : "+totalWrapping );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
}
