package com.rest.mutants.validators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DNAValidator {

	public static boolean isMutant(String[] dna) {
		Stream<String> strDNA = Stream.of(dna);
		int count = 0;
		int line = 0;
		int pos = 0;
		String aux = "";

		
		//Row
		count += (int) strDNA.filter(x -> x.matches(".*(AAAA|CCCC|GGGG|TTTT).*")).count();
		
		if (count > 1)
			return true;
		
		//Column
		while(line < dna.length - 4 && count < 2)
		{
			aux = dna[line] + dna[line+1] + dna[line+2] + dna[line+3];
			
			while(pos < dna.length && count < 2)
			{
				count += aux.matches(".{"+pos + "}((A).{"+(dna.length-1)+"}){3}(A).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((C).{"+(dna.length-1)+"}){3}(C).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((G).{"+(dna.length-1)+"}){3}(G).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((T).{"+(dna.length-1)+"}){3}(T).*") ? 1 : 0;
				pos++;
			}
			line++;
		}
		
		if (count > 1)
			return true;
		
		//This way \
		line = 0;
		
		while(line < dna.length - 3 && count < 2)
		{
			aux = dna[line] + dna[line+1] + dna[line+2] + dna[line+3];
			pos = 0;
			while(pos < dna.length - 3 && count < 2)
			{
				count += aux.matches(".{"+pos + "}((A).{"+(dna.length)+"}){3}(A).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((C).{"+(dna.length)+"}){3}(C).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((G).{"+(dna.length)+"}){3}(G).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((T).{"+(dna.length)+"}){3}(T).*") ? 1 : 0;
				pos++;
			}
			line++;
		}
		
		if (count > 1)
			return true;
		
		//This way /
		line = 0;
		
		while(line < dna.length - 3 && count < 2)
		{
			aux = dna[line] + dna[line+1] + dna[line+2] + dna[line+3];
			pos = dna.length - 1;
			
			while(pos >= 3 && count < 2)
			{
				count += aux.matches(".{"+pos + "}((A).{"+(dna.length-2)+"}){3}(A).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((C).{"+(dna.length-2)+"}){3}(C).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((G).{"+(dna.length-2)+"}){3}(G).*") ? 1 : 0;
				count += aux.matches(".{"+pos + "}((T).{"+(dna.length-2)+"}){3}(T).*") ? 1 : 0;
				pos--;
			}
			line++;
		}
		
		if (count > 1)
			return true;
		
		return false;
	}
	
	public static boolean isValid(String[] dna) {
		int lengt = dna.length;
		
		if(lengt == 0)
			return false;

		List<String> sequence = Arrays.asList(dna);
		
		for(String element : sequence)
		{
			if(element.matches(".*[^ACGT]{1,}.*") || element.length() != lengt) 
				return false;
		}
		
		return true;
	}

}
