from flask import Flask
import math
app = Flask(__name__)

@app.route('/')
def hello_world():
    # return render_template('hello.html')
    return '<h1>Hello World</h1>'

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
