Motivation

There are common situations when classes differ only in their behavior. For this cases is a good idea to isolate the algorithms in separate classes 
in order to have the ability to select different algorithms at runtime. 
Intent

Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that 
use it.

Implementation

Strategy Implementation UML Class Diagram

Strategy - defines an interface common to all supported algorithms. Context uses this interface to call the algorithm defined by a ConcreteStrategy.

ConcreteStrategy - each concrete strategy implements an algorithm.

Context
contains a reference to a strategy object.
may define an interface that lets strategy accessing its data.
The Context objects contains a reference to the ConcreteStrategy that should be used. When an operation is required then the algorithm is run from the 
strategy object. The Context is not aware of the strategy implementation. If necessary, addition objects can be defined to pass data from context object
 to strategy. 

The context object receives requests from the client and delegates them to the strategy object. Usually the ConcreteStartegy is created by the client 
and passed to the context. From this point the clients interacts only with the context.


Applicability & Examples


Example - Robots Application

Strategy Example Robot UML Class Diagram 

Let's consider an application used to simulate and study robots interaction. For the beginning a simple application is created to simulate an arena where 
robots are interacting. We have the following classes:

IBehaviour (Strategy) - an interface that defines the behavior of a robot

Conctete Strategies: AggressiveBehaviour, DefensiveBehaviour, NormalBehaviour; each of them defines a specific behavior. In order to decide the action 
this class needs information that is passed from robot sensors like position, close obstacles, etc.

Robot - The robot is the context class. It keeps or gets context information such as position, close obstacles, etc, and passes necessary information 
to the Strategy class.

In the main section of the application the several robots are created and several different behaviors are created. Each robot has a different behavior 
assigned: 'Big Robot' is an aggressive one and attacks any other robot found, 'George v.2.1' is really scared and run away in the opposite direction when
it encounter another robot and 'R2' is pretty calm and ignore any other robot. At some point the behaviors are changed for each robot.