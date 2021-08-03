# Encryption_Decryption
Simple program that can encrypt or decrypt your message. All parameters are passed as command line arguments. Strategy design pattern has beed used to switch between shifting and unicode algorithms.
## Features
* Support shifting or unicode encoding algorithms
* Input text can be read from file or passed as command-line argument
* Output can be printed in console or saved in file
## Setup
`-mode enc` for encryption or `-mode dec` for decryption, default: encryption

`-key NUMBER` to choose the key e.g. `-key 5`, default: 0

`-in FILENAME` to read input text from file e.g. `-in password.txt`

`-data STRING` to input the text directly e.g. `-data "Hello World"`, default: ""

`-out FILENAME` to save the output in file e.g. `-out output.txt`. default: print to the console

`-alg shift` for shifting algorithm or `-alg unicode` for unicode algorithm, default: shifting algorithm

If some parameters are missed the program takes the default settings.
