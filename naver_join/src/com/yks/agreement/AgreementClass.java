package com.yks.agreement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AgreementClass {
	
	private static String uri = null;
	private static ArrayList<String> agrArr = null;
	
	public AgreementClass() {
	}
	
	public static ArrayList<String> agr1() {
		uri = "D:/my_study/yks_data/naver_join/이용약관동의.txt";
		agrArr = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(uri);
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			while((temp = br.readLine()) != null){
				
				agrArr.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File read ERR : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readLine ERR : " + e.getMessage());
		}
		return agrArr;
	}
	
	public static ArrayList<String> agr2() {
		uri = "D:/my_study/yks_data/naver_join/개인정보 수집 및 이용에 대한 안내.txt";
		agrArr = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(uri);
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			while((temp = br.readLine()) != null){
				
				agrArr.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File read ERR : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readLine ERR : " + e.getMessage());
		}
		return agrArr;
	}
	
	public static ArrayList<String> agr3() {
		uri = "D:/my_study/yks_data/naver_join/위치정보 이용약관 동의.txt";
		agrArr = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(uri);
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			while((temp = br.readLine()) != null){
				
				agrArr.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File read ERR : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readLine ERR : " + e.getMessage());
		}
		return agrArr;
	}
}
