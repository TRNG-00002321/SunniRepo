import unittest
from unittest.mock import Mock, patch

from src import total

class TestTotal(unittest.TestCase):

    def test_total_positve(self):
        total.read = Mock()
        total.read.return_value=[1, 2, 3]
        result = total.calculate_total('')
        self.assertEqual(6.0, result)

    def test_calculate_test_path(self):
        with patch('src.total.read') as mock_read:
            mock_read.return_value =[2, 3, 4]
            result = total.calculate_total('')
            self.assertEqual(9.0, result)
        
    @patch('src.total.read')
    def test_calculate_total_patch_decorator(self, mock_read_decorator):
        mock_read_decorator.return_value = [2, 3, 4]
        result = total.calculate_total('')
        self.assertEqual(9.0, result)

    def multiply(self, values):
        result = 1
        for v in values:
            result *= v
        return result
    
    def sum_no_negative(self, values):
        if any(v < 0 for v in values):
            raise ValueError("Negative Values")
        return sum(values)


    @patch('src.total.read')
    def test_calculate_total_method_swap(self, mode_read_decorator):
        mode_read_decorator.return_value = [1, 2, 3, 4]
        with patch('src.total.sum', side_effect=self.multiply):
            result = total.calculate_total('')
        self.assertEqual(24, result)
        mode_read_decorator.assert_called_once_with('')



# if in a list, there is a negative number, then raise an execption
# Patch it with a sideffect
    @patch('src.total.read')
    def test_calculate_total_no_negatives(self, mode_read_decorator):
        mode_read_decorator.return_value  = [1, 2, -3, 4]
        with patch('src.total.sum', side_effect=self.sum_no_negative):
            with self.assertRaises(ValueError) as ve:
                total.calculate_total('')
                self.assertTrue('negative' in str(ve).lower())
