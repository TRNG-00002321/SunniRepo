import csv
from pathlib import Path
import pytest
from src.calculator import Calculator

@pytest.fixture
def database_connection():
    #Setup
    print('\nEstablishing Connection...')
    connection = 'simulated_db_connection'
    yield connection

    # Teardown
    print('\nClosing Connection')
    # connection.close()

def test_database_connection(database_connection):
    print(f'\nUsing db connection: {database_connection}')
    assert database_connection == 'simulated_db_connection'

def test_conftest_user(sample_data):
    assert sample_data['name'] == 'Alex'
    assert sample_data['age'] == 22

@pytest.mark.parametrize(
    'num1, num2, expected',
    [
        (1, 5, 6),
        (4, 2, 6),
        (5, -4, 1),
        (6, 23, 29)
    ]
)
def test_add_param(num1, num2, expected):
    calc = Calculator()
    assert calc.add(num1, num2) == expected


def load_csv(filename):
    file_path = Path(__file__).parent/'data'/filename
    with open(file_path, newline='') as f:
        return list(csv.DictReader(f))
    

@pytest.fixture
def add_data():
    return load_csv('add.csv')
def test_add_csv(add_data):
    calc = Calculator()
    for case in add_data:
        a = int(case["a"])
        b = int(case["b"])
        expected = int(case["expected"])
        assert calc.add(a, b) == expected
    

@pytest.mark.parametrize(
        'a,b,expected',
        [(int(case['a']), int(case['b']), int(case['expected'])) for case in load_csv('add.csv')]
)
def test_add_csv(a, b, expected):
    calc = Calculator()
    assert calc.add(a, b) == expected
    


