#!/bin/bash
echo "1.Addition"
echo "2.Substraction"
echo "3.Multiplication"
echo "4.Division" 

read -p "enter choice ::" choice
read -p "enter number 1 ::" num1
read -p "enter number 2 ::" num2
case $choice in
	1)
	
	 expr $num1 + $num2 
        
	;;
	2)
	     expr $num1 - $num2
	;;
	3)
		expr $num1 \* $num2
	;;
	4)
		expr $num1 / $num2
	;;
	*)
		echo "Invalid choice"	
	;;
	esac
