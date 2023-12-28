# functions
.count("'char'")  
    to count how many times a char gets used
.endswith("x")  
    to check if string ends with x
.isnumeric()  
    to check whether string consists of only numbers
.join()  
    to concatenate strings
.split() 
    to split every word in a string
dict.update() 
    method doesn't ADD the both method values. It sets the new val to old value! It 'updates' it!
[::-1] or .sort(reverse=True)
    reverses lists
dir() 
    function gives ALL the functions of the associated class. 
    (i.e dir("") gives functions of string class)
help() 
    gives the documentation of the class. 
    [use 'q' to quit]
os.path.join()
    allows for cross-platform class paths. 
    (solves \/ problems in file paths in difference with OS's)

# tips
* Tuple = "final" list.
* Attributes are characteristics associated with a type.
* Methods are functions associated with a type
* Automated consistency checks, such as hash checks on backups, can help identify problems ahead of time.

## Regex & grep
* '.' is a WC. 
    (i.e. t.. = tee, tea, tom...)

$grep ^fruit {location} ::: ['fruit, fruits, fruit's, fruity...']
     which means everything that starts with 'fruit'
$ grep cat$ {location} ::: ['cat, Mobcat, Teacat, pussycat...'] 
    (ends with 'cat')

* {'^', '$' are ANCHOR chars.},

* \w matches characters, numbers and underscores.
* \d matches 0-9
* \s matches white-space
* \w matches [a-zA-Z0-9_]
* \b 
    - essentially using anchor chars for EVERY word. 
    - So the regex will apply to every word one by one, instead of the total sentence.
    - By adding word boundaries (\b) at the beginning and end of the pattern, 
    we ensure that the pattern only matches phone numbers when they are surrounded by non-word characters 
    (such as spaces, punctuation, or the start/end of the string). 
    This prevents it from matching substrings within longer strings that resemble the phone number format.

* (?:...) is non-capturing group.
* :=   
    the WALRUS operator (new)