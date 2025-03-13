#!/bin/bash

# switch to using graal
sdk use java 21.0.6-graal

# create jar
# mvn clean package

# create binary & jar 
mvn clean package -Pnative


## now you can use like 
# java -jar target/html2pdf-with-dependencies.jar input.html output.pdf
# or
# ./target/html2pdf input.html output.pdf
