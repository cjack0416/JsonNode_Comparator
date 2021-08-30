#What the Comparator Does?

The main class in this repo that you should look at is the Comparator class.
It takes two Objects, converts them into JsonNodes using an ObjectMapper, 
and then parses through both JsonNodes to check for any mismatched values. 
Any mismatches found are appended to a StringBuilder which is then converted 
to a String and returned after all methods are finished.

#Why use this Comparator?

What makes the Comparator class useful is that it allows you to actually log
the mismatches found easily rather than just simply getting a true or false
if the Objects like you would get from a typical equals method.

#Using the Comparator

The Comparator is pretty simple to use. Just simply pass any two Objects to the
compare method, and you'll get a String of all the mismatching field values, or
an empty String if there were none. Feel free to clone the repo and make any use
or make any changes to the Comparator that you would like.

#Contributing

I currently don't have plans to allow contributions, however, I may be open to this
if I get interest from anyone to add some features. Send me an email, or message me on
Twitter if you're interested in contributing.