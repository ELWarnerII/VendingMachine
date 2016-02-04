Vending Machine
Author - Louis Warner
1/31/2016

**********************
*     Java Files     *
**********************

There are nine files necessary for running this program:
Item.java
MoneyInserted.java
NoMoneyInserted.java
OutOfOrder.java
StockMode.java
VendingMachine.java
VMState.java
VMtest.java
ItemList.txt

The first eight files are java files and should be stored 
in the directory ...VendingMachine/src and compiled there.
ItemList.txt can remain in the directory ...VendingMachine/.
The main program for the project lies in the VMTest.java file.
To run the program, run VMTest.java on the command line or in
an IDE.

**********************
*     Interface      *
**********************

The program will begin by welcoming the user and listing the available
options to interact with the machine.

After each attempted interaction, a message will be displayed indicating
the results of the interaction or a failed attempt to interact. The program
will then loop and ask for the next interaction. It will do this continually
until the user exits the program.