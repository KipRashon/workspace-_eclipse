import _mysql_connector 

class hello():
    print("hello world")
    a=input("Enter the first number")
  
    b=input("Enter the second number")
    print("\n")
    sum=int(a)+int(b);
    print(sum)
    print("sum ={}".format(sum))
    
    #getting connected to the databse
    