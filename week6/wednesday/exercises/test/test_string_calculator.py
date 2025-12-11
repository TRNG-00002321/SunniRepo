import pytest
from src.string_calculator import StringCalculator

class TestStringCalculator:
    
    def setup_method(self):
        self.calc = StringCalculator()

    def test_add_empty_string_returns_zero(self):
        assert self.calc.add("") == 0
    
    def test_add_single_number_returns_that_number(self):
        assert self.calc.add('1') == 1
    
    def test_add_multiple_numbers_returns_sum(self):
        assert self.calc.add('1, 2, 3') == 6
    
    def test_add_newline_delimiter(self):
        assert self.calc.add('1,\n2, 3') == 6

    def test_add_custom_delim(self):
        assert self.calc.add("//;\n1;2") == 3
        
    def test_add_ignore_over_thousand(self):
        assert self.calc.add('2, 1001') == 2
        assert self.calc.add('1000, 1001, 2') == 1002

    def test_add_negative_numbers_raises_error(self):
        with pytest.raises(ValueError) as ctx:
            self.calc.add('-1, 2')
            assert 'negatives not allowed' in str(ctx.value)
            assert '-1' in str(ctx.value)

    def test_add_multiple_negatives_show_all(self):
        with pytest.raises(ValueError) as ctx:
            self.calc.add('-1, 2, -3')
            error_msg = str(ctx.value)
            assert 'negatives not allowed' in error_msg
            assert '-1' in error_msg
            assert '-3' in error_msg
        