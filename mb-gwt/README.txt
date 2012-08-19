
This project generates code which can be deployed in a cordova native app.

The application has two input boxes to load external javascript.

To Generate Droid html and js code and deploy in the droid module run:
$ mvn clean package -Pdroid

To generate the ios code run:
$ mvn clean package -Pios

To run the project in superdev mode run:
$ mvn exec:java

To run the project in dev mode run:
$ mvn gwt:run



    (c) Manuel Carrasco Monino, 2012


