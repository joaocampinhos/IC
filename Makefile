J = java
JC = javac
JCC = javacc
DIR=Parser
TITLE ="cenas"

default: clean javacc javac

b: default run

clean:
	rm "*.class"
	@echo "Classes apagadinhas"

run:
	@echo "------------------"
	@echo " Run              "
	@echo "------------------"
	$(J)  $(DIR)

javacc:
	@echo "------------------"
	@echo " Javacc           "
	@echo "------------------"
	$(JCC) $(DIR).jj

javac:
	@echo "------------------"
	@echo " Java             "
	@echo "------------------"
	$(JC) $(DIR).java

