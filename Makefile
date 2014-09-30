J = java
JC = javac
JCC = javacc
DIR=Parser
TITLE ="cenas"

default: javacc javac run

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

