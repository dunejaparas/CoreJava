In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. 
Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class. 
This pattern comes under behavior pattern category.

Implementation
We are going to create a Game abstract class defining operations with a template method set to be final so that it cannot be overridden. 
Cricket and Football are concrete classes that extend Game and override its methods.


TemplatePatternDemo, our demo class, will use Game to demonstrate use of template pattern.

Template Pattern UML Diagram

Step 1
		Create an abstract class with a template method being final.

		Game.java

Step 2
		Create concrete classes extending the above class.
		
		Cricket.java
		Football.java

Step 3
		Use the Game's template method play() to demonstrate a defined way of playing game.

		TemplatePatternDemo.java

Step 4
		Verify the output.