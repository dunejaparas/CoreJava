Mediator design pattern is used to provide a centralized communication medium between different objects in a system. 
Mediator design pattern is very helpful in an enterprise application where multiple objects are interacting with each other.
If the objects interact with each other directly, the system components are tightly-coupled with each other that makes 
maintainability cost higher and not flexible to extend easily. Mediator pattern focuses on provide a mediator between 
objects for communication and help in implementing lose-coupling between objects.


Air traffic controller is a great example of mediator pattern where the airport control room works as a mediator for 
communication between different flights. Mediator works as a router between objects and it can have it’s own logic to 
provide way of communication. Check out Mediator Pattern post for implementation details with example program.



Mediator Pattern is one of the behavioral design pattern, so it deals with the behaviors of objects. Mediator design pattern is used to provide a 
centralized communication medium between different objects in a system. According to GoF, mediator pattern intent is:

		"Allows loose coupling by encapsulating the way disparate sets of objects interact and communicate 
			with each other. Allows for the actions of each object set to vary independently of one another."

Mediator design pattern is very helpful in an enterprise application where multiple objects are interacting with each other. If the objects interact 
with each other directly, the system components are tightly-coupled with each other that makes maintainability cost higher and not flexible to extend 
easily. Mediator pattern focuses on provide a mediator between objects for communication and help in implementing lose-coupling between objects.

Air traffic controller is a great example of mediator pattern where the airport control room works as a mediator for communication between different 
flights. Mediator works as a router between objects and it can have it’s own logic to provide way of communication.


 
The system objects that communicate each other are called Colleagues. Usually we have an interface or abstract class that provides the contract for 
communication and then we have concrete implementation of mediators.

For our example, we will try to implement a chat application where users can do group chat. Every user will be identified by it’s name and they can 
send and receive messages. The message sent by any user should be received by all the other users in the group.

Mediator Pattern in JDK

	java.util.Timer class scheduleXXX() methods
	Java Concurrency Executor execute() method.
	java.lang.reflect.Method invoke() method.
	

Important Points

1. Mediator pattern is useful when the communication logic between objects is complex, we can have a central point of communication that takes care of communication logic.
2. Java Message Service (JMS) uses Mediator pattern along with Observer pattern to allow applications to subscribe and publish data to other applications.
3. We should not use mediator pattern just to achieve lose-coupling because if the number of mediators will grow, then it will become hard to maintain them.


That’s all for mediator pattern and it’s implementation in java. If you liked it, share your love with comments.