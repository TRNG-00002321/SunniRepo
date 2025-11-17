# Create a dictionary of marks:
# Physics
# Chemisty
# Math
# Assign the marks a value and display them in a tabular format

from flask import Flask, render_template
app = Flask(__name__)

@app.route('/marks')
def display_marks():
    marks = {"Physics": 48,
             "Chemistry": 79,
             "Math": 80,}
    return render_template('marks.html', marks=marks)
if __name__ == '__main__':
    app.run(debug=True)