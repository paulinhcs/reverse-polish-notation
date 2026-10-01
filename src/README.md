# Calculator Reverse Polish Notation

The program calculates an expression using Reverse Polish Notation (RPN).

## How does it work?

The user's input will be converted into tokens. Then, the tokens will be organized into a Reverse Polish 
Expression (RPN). Finally, the expression will be evaluated and its result will be returned. 
The stack data structure will be used to help with the process.

input → split into tokens → convert to Reverse Polish Notation → evaluate expression → output.

## The program accepts:

- Opening and closing parentheses.
- Addition, subtraction , multiplication, and division operators.
- Decimal numbers.

### Stack

A stack is a data structure that follows the Last in, First Out (LIFO) principle. I implemented 
my own stack for this program and didn't use any collection because the objective is to study and
practice data structures and Java.

### Tokenizer

Converts the input into tokens. I could have used the StringTokenizer for this part, but I wanted to try implementing
my own tokenizer.

### Parser

Converts the expression into Reverse Polish Notation (RPN).

### Evaluator

Evaluates the Reverse Polish Notation (RPN) expression and returns the result.

### The program output

- The expression input provided by the user in its original form;
- The expression converted into Reverse Polish Notation (RPN);
- The result of the expression.

## Rules Reverse Polish Notation

There will be two stacks: one for the output and one for the operators.

### If it's a number:
- Push it onto the output stack.

### If it's an opening parenthesis:
- Push it onto the operator stack.

### If it's a closing parenthesis:
- Pop all operators from the operator stack and push them onto the output stack until you find the opening parenthesis.

### If it's an operator:
- Check the item at the top of the operator stack:
    - If it's not an operator, push the operator onto the operator stack.
    - If it is an operator, check its priority:
        - If the operator at the top of the operator stack has higher or equal priority, pop it from the operator stack and push it onto the output stack. Repeat until you find a non-operator (parenthesis).
        - Otherwise, push the operator onto the operator stack.


## Input examples:

### Valid inputs:

#### `3.5 + 4.2 * 2`
#### `3.5 4.2 2 * +`
Result: `11.9`

#### `15.5 - 3 + 2`
Result: `14.5`

#### `100 / 4 / 5`
Result: `5.0`

#### `(7.2 / 2.4) + (5.5 * 2) - 4`
Result: `10`

#### `5.0 - (2.5 * 4.0) + 1.2`
Result: `-3.8`


### Invalid inputs:

#### `3.5 + * 2`

#### `(5.2 + 3.1`

#### `10 / / 2`

#### `7.5 + 2.3)`

#### `4.2 + abc`
