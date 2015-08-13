package com.pd.core.prepare.output;

public class If2 {
    static boolean b1, b2;

    public static void main(final String[] args) {
	int x = 0;
	if (!b1) /* Line 7 */
	{
	    if (!b2) /* Line 9 */
	    {
		b1 = true;
		x++;
		if (5 > 6) {
		    x++;
		}
		if (!b1) {
		    x = x + 10;
		} else if (b2 = true) {
		    x = x + 100;
		} else if (b1 | b2) {
		    x = x + 1000;
		}
	    }
	}
	System.out.println(x);
	main();

	getOutput();
    }

    private static void getOutput() {
	// int i = 0;
	// while (1) {
	// if (i == 4) {
	// break;
	// }
	// ++i;
	// }
	// System.out.println("i = " + i);


    }

    static boolean b;

    static void main() {
	short hand = 42;
	if (hand < 50 && !b) {
	    hand++;
	}
	if (hand > 50) {
	    ; /* Line 9 */
	} else if (hand > 40) {
	    hand += 7;
	    hand++;
	} else {
	    --hand;
	}
	System.out.println(hand);
    }
}

