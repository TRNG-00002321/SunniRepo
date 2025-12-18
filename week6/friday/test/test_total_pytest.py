import pytest
from src import total

def test_calculate_total_multiply(mocker):
    mock_read = mocker.Mock()
    mock_read.return_value = [1, 2, 3, 4]
    total.read = mocker.patch()

    mock_sum = mocker.Mock()
    mocker.patch('src.total.sum', side_effect=multiply)
    result =  total.calculate_total('')
    assert result == 24
    total.read.assert_called_once_with('')

def test_calculate_total(mocker):
    mock_read = mocker.Mock()
    mock_read.return_value = [1, 2, 3]
    total.read = mock_read
    assert total.calculate_total('') == 6
    mock_read.assert_called_once_with('')


def multiply(values):
    result = 1
    for v in values:
        result *= v
    return result

def test_calculate_total_multiply(mocker):
    mock_read = mocker.Mock()
    mock_read.return_value = [1, 2, 3, 4]
    total.read = mock_read
    mocker.patch('src.total.sum', side_effect=multiply)
    result =  total.calculate_total('')
    assert result == 24
    total.read.assert_called_once_with('')


def sum_no_negative(values):
    if any(v < 0 for v in values):
        raise ValueError("Negative Values")
    return sum(values)

def test_calculate_no_negative(mocker):
    mocker.patch('src.total.read', return_value = [1, 2, -3, 4])
    mocker.patch('src.total.sum', side_effect=sum_no_negative)
    with pytest.raises(ValueError) as ve:
        total.calculate_total('')
    assert 'Negative Values' in str(ve.value)
