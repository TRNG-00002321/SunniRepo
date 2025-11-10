from flask import Flask, url_for, redirect

app = Flask(__name__)


@app.route('/admin/<admin>')
def hello_admin(admin):
    return 'Hello Admin %s' % admin

@app.route('/guest/<name>')
def hello_guest(name):
    return 'Hello Guest %s' % name

@app.route('/user/<username>')
def hello_user(username):
    if username == 'admin':
        # dynamically builds url for a specific function
        return redirect(url_for('hello_admin', admin=username))
    else:
        return redirect(url_for('hello_guest', name=username))

if __name__ == '__main__':
    app.run(debug=True)