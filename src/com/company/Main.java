package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	MyHashMap<Integer,String>  test= new MyHashMap<>();
	HashMap<String,String> a= new  HashMap<>();
	test.insert(null,null);
	test.insert(null,"ff");
	test.insert(8,"НЕволк");
	test.insert(66,"Волк");
	test.insert(98,"НЕволк");
	test.insert(928,"НЕволк");
	System.out.println(test.size());
	System.out.println(test.get(null));

	}
}
