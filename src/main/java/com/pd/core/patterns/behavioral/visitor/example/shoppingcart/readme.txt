Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects.
With the help of visitor pattern, we can move the operational logic from the objects to another class.

For example, think of a Shopping cart where we can add different type of items (Elements), when we click on checkout button, 
it calculates the total amount to be paid. Now we can have the calculation logic in item classes or we can move out this logic 
to another class using visitor pattern. Let’s implement this in our example of visitor pattern. Check out Visitor Pattern post 
for implementation details.


To implement visitor pattern, first of all we will create different type of items (Elements) to be used in shopping cart.