import pytest
from src.calculator import Calculator

@pytest.fixture
def calculator():
    return Calculator()

@pytest.fixture
def other():
    return None

def test_add(calculator):
    # calculator = Calculator()
    result = calculator.add(3, 2)
    assert result == 5

def test_is_even_even(calculator):
    # calculator = Calculator()
    assert calculator.is_even(4)

def test_is_even_odd(other):
    # calculator = Calculator()
    assert not calculator.is_even(5)

def test_divide_by_zero():
    calculator = Calculator()
    with pytest.raises(ZeroDivisionError):
        calculator.divide(3, 0)

def test_divide_by_zero_context():
    calculator = Calculator()
    with pytest.raises(ZeroDivisionError) as context:
        calculator.divide(3, 0)
    assert 'zero' in str(context)
