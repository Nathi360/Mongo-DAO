make:
	find -name "*.java" > sources.txt && javac -cp \* @sources.txt

run:
	java -cp .:\* Initiator

pack:
	find -name "*.class" > compiled.txt && jar cfe Mongo-Access.jar Initiator @compiled.txt

launch:
	java -jar Mongo-Access.jar -cp \*

clean:
	rm *.class && rm sources.txt

