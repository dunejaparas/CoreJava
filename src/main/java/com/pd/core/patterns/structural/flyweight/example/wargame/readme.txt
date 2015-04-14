Java Source Code Example for the Flyweight Pattern - WarGame

Consider for example a game of war, were there is a large number of soldier objects; a soldier object maintain the graphical representation of a soldier, 
soldier behavior such as motion, and firing weapons, in addition soldier�s health and location on the war terrain. The solution is to keep the common 
state of soldiers in a shared object

The war game example instantiates 5 Soldier clients, each client maintains its internal state which is extrinsic to the soldier flyweight. And Although 
5 clients have been instantiated only one flyweight Soldier has been used.

