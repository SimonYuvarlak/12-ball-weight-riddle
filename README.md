# 12-ball-weight-riddle
This is a Java program to solve a common problem called 12 ball weight riddle

You have 12 balls identical in size and appearance but 1 is an odd weight (could be either light or heavy).

You have a set of balance scales which will give 3 possible readings:

Left = Right,
Left > Right, or
Left < Right
(i.e. Left and Right have equal weight, Left is Heavier, or Left is Lighter).

You have only 3 chances to weigh the balls in any combination using the scales.

Find which ball is the odd one and if it's heavier or lighter than the rest.

How do you do it?

Solution :
Number the balls 1, 2, 3, ... 10, 11, 12

Start off with them in 3 groups: [1, 2, 3 and 4], [5, 6, 7 and 8] and [9,10,11 and 12]

Weigh 1, 2, 3 and 4 vs 5, 6, 7 and 8 with 3 possible outcomes:


1. If they balance then 9,10,11,12 have the odd ball, so weigh 6,7,8 vs 9,10,11 with 3 possible outcomes:
 	1a	If 6,7,8 vs 9,10,11 balances, 12 is the odd ball. Weigh it against any other ball to determine if heavy or light.
 	1b	If 9,10,11 is heavy then they contain a heavy ball. Weigh 9 vs 10, if balanced then 11 is the odd heavy ball, else the heavier of 9 or 10 is the odd heavy ball.
 	1b	If 9,10,11 is light then they contain a light ball. Weigh 9 vs 10, if balanced then 11 is the odd light ball, else the lighter of 9 or 10 is the odd light ball.
 	 	 
2. If 5,6,7,8 > 1,2,3,4 then either 5,6,7,8 contains a heavy ball or 1,2,3,4 contains a light ball so weigh 1,2,5 vs 3,6,12 with 3 possible outcomes:
 	2a	If 1,2,5 vs 3,6,12 balances, then either 4 is the odd light ball or 7 or 8 is the odd heavy ball. Weigh 7 vs 8, if they balance then 4 is the odd light ball, or the heaviest of 7 vs 8 is the odd heavy ball.
 	2b	If 3,6,12 is heavy then either 6 is the odd heavy ball or 1 or 2 is the odd light ball. Weigh 1 vs 2, if balanced then 6 is the odd heavy ball, or the lightest of 1 vs 2 is the odd light ball.
 	2c	If 3,6,12 is light then either 3 is light or 5 is heavy. Weigh 3 against any other ball, if balanced then 5 is the odd heavy ball else 3 is the odd light ball.
 	 	 
3. If 1,2,3,4 > 5,6,7,8 then either 1,2,3,4 contains a heavy ball or 5,6,7,8 contains a light ball so weigh 5,6,1 vs 7,2,12 with 3 possible outcomes:
 	3a	If 5,6,1 vs 7,2,12 balances, then either 8 is the odd light ball or 3 or 4 is the odd heavy ball. Weigh 3 vs 4, if they balance then 8 is the odd light ball, or the heaviest of 3 vs 4 is the odd heavy ball.
 	3b	If 7,2,12 is heavy then either 2 is the odd heavy ball or 5 or 6 is the odd light ball. Weigh 5 vs 6, if balanced then 2 is the odd heavy ball, or the lightest of 5 vs 6 is the odd light ball.
 	3c	If 7,2,12 is light then either 7 is light or 1 is heavy. Weigh 7 against any other ball, if balanced then 1 is the odd heavy ball else 7 is the odd light ball.
