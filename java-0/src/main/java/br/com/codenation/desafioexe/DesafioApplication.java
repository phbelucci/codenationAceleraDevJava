package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci(){

		List<Integer> fiboNumbers = new ArrayList<>();

		int maxNumber = 350;
		int number = 0;

		fiboNumbers.add(0);
		fiboNumbers.add(1);

		while(fiboNumbers.get(fiboNumbers.size() - 1) <= maxNumber){

				fiboNumbers.add(fiboNumbers.get( fiboNumbers.size() - 1) + fiboNumbers.get(fiboNumbers.size() - 2));
				number++;
		}
		return fiboNumbers;

	}

	public static Boolean isFibonacci(Integer n){
		return fibonacci().contains(n);
	}

}