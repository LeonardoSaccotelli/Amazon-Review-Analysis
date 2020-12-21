# Amazon-Review-Analysis
A simple Java application to test the use of NoSql database. We use Redis, in-memory key-value database.
The dataset consists of a list of restaurants with data relating to both the GPS position and the cost, evaluations, services offered, type of cuisine.
The application extracts the data from the dataset (in csv format) and uploads the data to Redis. 
The application performs some query tests by simulating the user's GPS position and extrapolating information about restaurants within a certain radius of the user's location.
The geospatial indexes offered by Redis are used to perform these queries.

Project developed during the Database Design with New Generation Models course @ [Department of Computer Science](https://www.uniba.it/ricerca/dipartimenti/informatica) @ [University of Bari "Aldo Moro"](http://www.uniba.it/)
under the supervision of dr. [Nicola Fanizzi](http://lacam.di.uniba.it:8000/people/nicola.html).

## Prerequisites

By default, requirement for compilation are:
* JDK 11+
* Maven

Requirement for running application is:
* MongoDB 4+

## Using from MongoDB Shell
You can download the dataset from [here](https://docs.google.com/forms/d/e/1FAIpQLSeniNBetoz83H0QXxrfxPNoq7g6pkbAEcqrlrYiNJXZD5YT6g/viewform). Then you have to import
the dataset in your MongoDB typing in shell.
````
$ mongoimport --db AmazonReview --collection ElectronicsReview --file ~\Electronics.json
````
Now you have to run the commands in folder ```Mongo-Db-Shell-Command``` to clean the dataset from unused field, to create indexes and to convert String time in Date time.
You can find these commands in the following files:
````
RemoveUnusedField.js
CreateIndex.js.
ConvertStringDateToDate.js
````
In the same folder there are different javascript files with different example query.

## Built with Maven
To create a jar file with dependencies including resource files:
````
$ mvn install
````

## Using from Spring Boot
Application can be run from root folder by typing into terminal:
````
$ mvn spring-boot:run
````
Now from your browser you can typing (the params are simple example of data stored in MongoDB):
````
localhost:8080/findAllReview
localhost:8080/findAllReviewByReviewId/5fde0efa87b13538889e95c7
localhost:8080/findAllReviewByProductId/0060009810
localhost:8080/findAllReviewByUserId/A1N070NS9CJQ2I
localhost:8080/findAllReviewWithRatingGreaterThan/3
````

## License
This software is released under the MIT License. See the [LICENSE](LICENSE) file for details.
