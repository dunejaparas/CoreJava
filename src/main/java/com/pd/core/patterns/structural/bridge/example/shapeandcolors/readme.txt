When we have interface hierarchies in both interfaces as well as implementations, then builder design pattern is used to 
decouple the interfaces from implementation and hiding the implementation details from the client programs. 
Like Adapter pattern, its one of the Structural design pattern.

According to GoF bridge design pattern is:
		Decouple an abstraction from its implementation so that the two can vary independently

The implementation of bridge design pattern follows the notion to prefer Composition over inheritance.

→ ← ↑ ↓


If we look into this design pattern with example, it will be easy to understand. Lets say we have an interface hierarchy in both interfaces and implementations like below image.

								Interface
									↑
				_____________________________________________
				↑											↑	
			Triangle										Pentagon
		↑			↑					Color			↑				↑				
Red Color(*)		Green Color(*)						Red Color(*)	Green Color(*)


	NOTE:		Also Red Color and Green Color both extend from Color



Now we will use bridge design pattern to decouple the interfaces from implementation and the UML diagram for the classes and interfaces after applying bridge pattern will look like below image.


		Shape				___________→					IColor (applyColor)
Shape and applyColor										applyColor		
		↑   ↑								Red Color				Green Color
		
Triangle	Pentagon		