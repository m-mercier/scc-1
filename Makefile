JFLAGS = -g -Xlint:unchecked
JC = javac
SRCDIR = src
JDOC = javadoc

SOURCES = $(shell find $(SRCDIR) -type f -name '*.java')

CLASSES = $(SOURCES:.java=.class)

%.class : %.java
	$(JC) $(JFLAGS) $<

default: $(CLASSES)

docs:
	$(JDOC) -d docs/ src

clean:
	$(RM) $(shell find $(SRCDIR) -type f -name '*.class')
