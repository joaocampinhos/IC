J = java
JC = javac
JCC = javacc
DIR=Parser

default: javacc javac run

run: classes
	$(call log,Run)
	$(J)  $(DIR)

classes: $(CLASSES:.java=.class)

javacc:
	$(call log,Javacc)
	$(JCC) $(DIR).jj

javac:
	$(call log,Javac)
	$(JC) $(DIR).java

log=\
	@echo "------------------\n $(1)            \n------------------"
