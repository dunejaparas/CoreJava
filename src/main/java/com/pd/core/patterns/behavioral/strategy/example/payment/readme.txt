Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.

Strategy pattern is also known as Policy Pattern. We defines multiple algorithms and let client application pass the algorithm to be used as a parameter. 
One of the best example of this pattern is Collections.sort() method that takes Comparator parameter. Based on the different implementations of Comparator 
interfaces, the Objects are getting sorted in different ways.

For our example, we will try to implement a simple Shopping Cart where we have two payment strategies – using Credit Card or using PayPal.


Check out Strategy Pattern post for implementation details and example program.
