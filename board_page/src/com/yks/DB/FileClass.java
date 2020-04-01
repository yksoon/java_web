package com.yks.DB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileClass {

	public FileClass() {
	}
	
	public static ArrayList<String> fileRead() {
		ArrayList<String> top = new ArrayList<String>();
		
		String uri = "D:/my_study/yks_data/top1000.txt";
		FileReader fr;
		try {
			fr = new FileReader(uri);
			BufferedReader br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null){				
			top.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FILE READ ERR : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("READ LINE ERR : " + e.getMessage());
		}
		
		return top;
	}

}
