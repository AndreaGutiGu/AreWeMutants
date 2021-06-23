# AreWeMutants

This is a simple REST API to determine if a DNA sequence belongs to a Mutant or a Human.

Each ADN sequence element is a string composed by letters A, C, G or T, and the comple ADN is a list of elements. The length of the list must be the same as the length of each element.

A Mutant sequence is such one has at least two groups of 4 succesive letter A, C, G or T in any direction (Horizontal, Vertical, Ortogonal)

<h2>Download and execute this project</h2>
This is a Spring boot project which uses maven and is connected to a MySQL database.

After downloading this project you can compile it by executing this command, from the location of the POM file:
<center><img src="https://user-images.githubusercontent.com/44385221/123023478-0dd01900-d39d-11eb-9ee4-d66b862cce9a.png" ></center>

Be sure to update the file application.properties with the data for your database.

Because this was deployed by Google App Engine, packaging is set to jar in the POM file; to deploy it as a WAR, just change the packaging to WAR:
<center><img src="https://user-images.githubusercontent.com/44385221/123024451-ae730880-d39e-11eb-82b9-6d95045bfb76.png" ></center>


<h2>Execute existent service</h2>

To determine if a DNA sequence, the POST service https://mutants-317611.rj.r.appspot.com/mutant is available by sending a JSON query with this format
<center><img src="https://user-images.githubusercontent.com/44385221/123018381-107a4080-d394-11eb-86f3-509f5272511d.png" ></center>


To get the number of sequences validated belonging to each class and the relation between two numbers, the GET service https://mutants-317611.rj.r.appspot.com/stats is available. Resul is given in JSON format:
<center><img src="https://user-images.githubusercontent.com/44385221/123018138-a19ce780-d393-11eb-9ecb-fe19974bb675.png" ></center>

This is the link for a Collection of tests from Postman
https://www.getpostman.com/collections/c0aadcc0e89d71030798
