# COMMANDS
SBT = sbt
CHR = google-chrome
MK = make

# FLAGS
& = &

# ACTIONS
RUN = run
CONTRUN = ~run
DOC = doc

# FILES
APIDOC = "target/scala-2.13/api/index.html"



all:
	$(SBT) $(RUN)

contRun:
	$(SBT) $(CONTRUN)

openApiDoc:
	$(SBT) $(DOC)
	$(CHR) $(APIDOC) $(&)

