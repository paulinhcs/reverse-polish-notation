# Calculator Reverse Polish Notation

I'll make a calculator with reverse polish notation. 

So:

input -> validate input -> convert to reverse polish -> calculate -> output 

Stack: it will help me a make the reverse polish, and I'll make to the zero, without native collections
Parser: translate in rpn expression
Tokenizer: convert the input in tokens
Evaluator: it will calculate the result of expression

some classes:

- calculator.stack
- convert to rpn (with aux methods?)
- and calculate

some rules:

- valid operators (plus, minus, division and multiple)
- aux (opening and closing parentheses)
- it will be able to handle double numbers too

The timeline is:

- user write the expression as input
- convert the expression to tokens
- clean blanks and validate tokens
- use the calculator.stack to convert to rpn
- calculate the expression in rpn 
- as output the value of expression

the objective is show to user

- the expression input in your infinitive form
- the expression in your rpn form
- and finally your value


My English is bad, but I'll write in English,
anyway, I just want to improve it too. I don't know lol
I'll polish all this stuff
