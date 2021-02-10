# AreWeMutants

This is a simple REST API to know if a ADN sequence belongs to a Mutant or a Human

Each ADN sequence element is a string composed by letters A, C, G or T, and the comple ADN is a list of elements.

A Mutant sequence is such one has at least two groups of 4 succesive letter A, C, G or T in any direction (Horizontal, Vertical, Diagonal)



To know if a DNA sequence, the POST service https://arewemutants.rj.r.appspot.com/mutant is available, sending a JSON query with this format
<p>{
<p>    "dna":["ATGCGA", "CAAGGC", "TTGTZT","AGACGG","CCCCTA","TCACTG"]
<p>}

To get the number of sequences validated belonging to each class and the relation between two numbers, the GET service https://arewemutants.rj.r.appspot.com/stats is available.
