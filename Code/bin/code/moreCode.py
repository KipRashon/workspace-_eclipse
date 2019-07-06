class moreCode:
    global count;
    def sayHi(self):
        print("Hi kiptoo how is your day")
        count=count+1;
    def __init__(self):
        count=0;
    for a in range(1,10):
        self.sayHi();
        
    print(count)