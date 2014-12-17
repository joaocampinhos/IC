J   = java
JC  = javac
JCC = javacc
DIR = Parser

default: clean javacc javac

interpretor: default run
i: interpretor

compile: default comp
c: compile

clean:
	rm -f ./*.class

run:
	@echo "------------------"
	@echo " Interpretor      "
	@echo "------------------"
	$(J) Main i

comp:
	@echo "------------------"
	@echo " Compiling        "
	@echo "------------------"
	$(J) $(DIR) $(input) $(output)
	cp compile/t1 compile/t1.tmp
	sed -i'.bak' s/Demo/$(output)/g compile/t1.tmp
	cat compile/t1.tmp ctmp compile/t2 > ctmp.j
	java -jar compile/jasmin.jar ctmp.j
	rm ctmp ctmp.j
	@echo "------------------"
	@echo "run with: java $(output)"

javacc:
	$(JCC) $(DIR).jj

javac:
	$(JC) *.java

