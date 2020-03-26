package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	MyHashMap<Integer,String>  test= new MyHashMap<>();
	test.insert(3,"Волк");
	test.insert(8,"НЕволк");
	test.insert(66,"Волк");
	test.insert(98,"НЕволк");
	test.insert(46,"Волк");
	test.insert(928,"НЕволк");
	test.insert(1,"Волк");
	test.insert(4,"НЕволк");
	test.insert(3,"gg");
	test.insert(77,"Волк");
	test.insert(65,"котик");
	test.insert(64,"Волк");
	test.insert(93,"НЕволк");
	test.insert(100,"Волк");
	test.insert(22,"Волк");
	test.insert(23,"зайчик");
	test.insert(25,"НЕволк");
	test.insert(27,"Волк");
	test.insert(29,"поросенок");
	System.out.println(test.get(3));
	System.out.println(test.get(29));
	System.out.println(test.size());
    }
}
