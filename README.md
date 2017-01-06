# spring-phonebook #

This repository demonstrates how to create a basic web application using Spring Framework, connected with PostgreSQL deployed in Heroku.

### How do I get set up? ###

* Compile
 
    ```bash
    $ gradle clean build
    ```
* Deploy
 	
 	```bash
	$ git push heroku master
	```  

* Run Server

    ```bash
    $ heroku ps:scale web=1
    ```

* Use  
    By default the server will serve at:
    > http://\<your\_heroku\_endpoint\>:8080/
    
    You can get the list of the people in the phonebook by calling:
    > http://\<your\_heroku\_endpoint\>:8080/phonebook/
    
    You can search a name from the phonebook by calling:
    > http://\<your\_heroku\_endpoint\>:8080/phonebook?name=\<name\_to\_search\>


### How do I contribute? ###

* Add your name and e-mail address into CONTRIBUTORS.txt
