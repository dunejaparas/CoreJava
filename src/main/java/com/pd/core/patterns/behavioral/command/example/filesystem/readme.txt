Command Pattern is used to implement lose coupling in a request-response model. 
In command pattern, the request is send to the invoker and 
invoker pass it to the encapsulated command object. Command object passes the request to the appropriate method of Receiver to perform the 
specific action.

Let’s say we want to provide a File System utility with methods to open, write and close file and it should support multiple operating systems 
such as Windows and Unix.

To implement our File System utility, first of all we need to create the receiver classes that will actually do all the work. Since we code in 
terms of java interfaces, we can have FileSystemReceiver interface and it’s implementation classes for different operating system flavors such 
as Windows, Unix, Solaris etc. Check out Command Pattern post for the implementation details with example program.

