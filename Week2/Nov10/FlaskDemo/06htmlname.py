from flask import Flask, render_template, request, redirect, url_for
app = Flask(__name__)

@app.route('/hello/<name>')
def hello_name(name):
    return render_template('helloname.html', name=name)

@app.route('/score/<int:score>')
def hello_score(score):
    return render_template('helloscore.html', score=score)


if __name__ == '__main__':
    app.run(debug=True)
