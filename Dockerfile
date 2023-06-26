FROM bellsoft/liberica-openjdk-alpine:latest

COPY ./src ./java
RUN mkdir ./out
RUN javac -sourcepath ./java -d out java/gb/lesson1/entry/Main.java
RUN javadoc -d javadoc -sourcepath ./java -cp ./out -subpackages gb
CMD java -classpath ./out gb.lesson1.entry.Main
