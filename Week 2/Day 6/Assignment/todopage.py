from flask import Flask, render_template, request

import todo_module

app = Flask(__name__)
my_todo = todo_module.read_file('todo.json')


@app.route('/', methods=['POST', 'GET'])
def index():
    return render_template('todo.html', todo=my_todo)

@app.route('/add', methods=['POST', 'GET'])
def add_task():
    my_todo[request.args.get('task')] = False
    todo_module.write_file("todo.json", my_todo)
    return render_template('todo.html', todo=my_todo)

@app.route('/delete', methods=['POST', 'GET'])
def remove_task():
    my_todo.pop(request.args.get('task'))
    todo_module.write_file("todo.json", my_todo)
    return render_template('todo.html', todo=my_todo)

@app.route('/update', methods=['POST', 'GET'])
def update_task():
    my_todo[request.args.get('task')] = True
    todo_module.write_file("todo.json", my_todo)
    return render_template('todo.html', todo=my_todo)


if __name__ == '__main__':
    app.run(debug=True)