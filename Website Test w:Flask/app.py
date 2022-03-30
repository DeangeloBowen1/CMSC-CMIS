"""Deangelo Bowen
SDEV 300
Feb 19, 2022
This program serves as purpose to fulfill the Lab 6, Week 6requirement under
UMGC SDEV 300 6834 """



from datetime import date
from flask import Flask
from flask import render_template

app = Flask(__name__, template_folder='template')


@app.route('/')
@app.route('/main.html')
def home():
    """Front Page hml renderer with date function"""
    return render_template('main.html', date=date.today())


@app.route('/page2.html')
def page2():
    """Second Page hml renderer with date function"""
    return render_template('page2.html', date=date.today())


@app.route('/page3.html')
def page3():
    """Third Page hml renderer with date function"""
    return render_template('page3.html', date=date.today())


if __name__ == '__main__':
    app.run(debug=True)
