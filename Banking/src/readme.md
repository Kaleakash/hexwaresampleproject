1. Create the database with name bank 
2. Create the table Account with three columns as 
    accNum, name and amount where accNum is primary key 
3. Then open DbConnetion class then change databaseName,userName and password 
4. Then open the AccountDao interface write the four methods which help to createAccount, withdraw, deposite and checkBalance. 
5. Then open the Account factory class call dao method If method return Account object then return the object as it to CliMain, If method return int value then return the appropriate message as a string to CliMain class.
Then in CliMain using swith call the respective method of the operation in CliMain and call the factory method with the help of AccountFactory class. 