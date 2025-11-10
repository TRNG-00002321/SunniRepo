from flask import Flask
import math
app = Flask(__name__)

@app.route('/')
def hello_world():
    return "Hello World"

@app.route('/hello')
def hello_again():
    return "Hello Again"

def hi_there():
    return "Hi There"
app.add_url_rule('/hi', view_func=hi_there)

@app.route('/hello/<name>')
def hi_name(name):
    return 'Hi, %s!' % name.upper()

@app.route('/square/<int:num>')
def square(num):
    return '%d' % (num * num)

@app.route('/area/<float:radius>')
def area(radius):
    return 'Area is %f' % (math.pi * radius ** 2)

@app.route('/add/<int:num1>/<int:num2>')
def add(num1, num2):
    return '%d + %d = %d' % (num1, num2, num1 + num2)

if __name__ == '__main__':
    app.run(debug=True) # Starts the server on port 5000