from macpath import split
var='This is kiptoo'

# print("if isspace %s"%(var.isspace()))
# print("if istitle %s"%(var.istitle()))
# print("if is upper %s"%(var.isupper()))
# print("if is upper %s"%(var.isupper()))
# me="I am kiptoo rashon"
# print("%c"%max(me))
# print("%c"%min(me))
words=list()
words=var.split(sep=" ")
print(var+" has been split and resulst in the following list")
for word in words:
    print(word)
print("this is the tilted case version of a string")
print(var.title())
print("this convers all lowecase letters to upper case")
print (var.upper())
print("this does the rstrip")
print (var.rstrip())
    