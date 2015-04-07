Adapter design pattern is one of the structural design pattern and its used so that two unrelated interfaces can work together. 
The object that joins these unrelated interface is called an Adapter. As a real life example, we can think of a mobile charger 
as an adapter because mobile battery needs 3 volts to charge but the normal socket produces either 120V (US) or 240V (India). 
So the mobile charger works as an adapter between mobile charging socket and the wall socket.

We will try to implement multi-adapter using adapter design pattern in this tutorial.

So first of all we will have two classes – Volt (to measure volts) and Socket (producing constant volts of 120V).