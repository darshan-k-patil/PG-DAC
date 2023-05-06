#!/bin/bash
 read -p "Enter number" num
ans=` expr $num % 2`
if [ $ans -eq 0 ]
then
 echo "$num is even"
 else 
 echo "$num is odd"
fi
