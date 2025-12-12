import sys
import unittest
from src.calculator import Calculator

class TestCalculator(unittest.TestCase):
    def setUp(self):
        self.calculator = Calculator()
    def test_add(self):
        n1 = 1
        n2 = 2
        expected = 3
        actual = self.calculator.add(n1, n2)
        self.assertEqual(expected, actual)

    def test_subtract(self):
        n1 = 5
        n2 = 3
        expected = 2
        actual = self.calculator.subtract(n1, n2)
        self.assertEqual(expected, actual) 

    def test_divide_by_zero(self):
        with self.assertRaises(ZeroDivisionError):
            self.calculator.divide(1, 0)

    def test_divide_by_zero_context(self):
        with self.assertRaises(ZeroDivisionError) as ctx:
            self.calculator.divide(1, 0)
        self.assertTrue('divide by zero' in str(ctx.exception))

    def test_isEven_even(self):
        n = 4
        self.assertTrue(self.calculator.is_even(n))

    def test_isEven_odd(self):
        n = 5
        self.assertFalse(self.calculator.is_even(n))

    @unittest.skipIf(sys.platform == 'linux', 'Skipping on Linux')
    def test_windows_only(self):
        self.assertTrue(True)
    def tearDown(self):
        self.calculator = None
