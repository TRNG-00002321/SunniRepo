from flask import Flask, request, redirect, url_for

app = Flask(__name__)

@app.route('/post/<name>')
def handle_post(name):
    return 'Welcome %s!' % name

@app.route('/getting/<name>')
def handle_get(name):
    return 'Welcome %s!' % name

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        return redirect(url_for('handle_post', name=request.form['nm']))
    else:
        return redirect(url_for("handle_get", name=request.args.get('nm')))

if __name__ == '__main__':
    app.run(debug=True)
