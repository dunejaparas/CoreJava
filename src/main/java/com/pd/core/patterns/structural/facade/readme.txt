Facade Pattern is used to help client applications to easily interact with the system. 

Suppose we have an application with set of interfaces to use MySql/Oracle database and to generate different types of reports, 
such as HTML report, PDF report etc. So we will have different set of interfaces to work with different types of database. 

Now a client application can use these interfaces to get the required database connection and generate reports. 
But when the complexity increases or the interface behavior names are confusing, client application will find 
it difficult to manage it. So we can apply Facade pattern here and provide a wrapper interface on top of the 
existing interface to help client application. Check out Facade Pattern post for implementation details and sample program.