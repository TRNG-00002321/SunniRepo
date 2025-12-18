import unittest
from unittest.mock import Mock

def greet(func):
    return "Hello, " + func()

class TestMockBasic:

    def test_mock_return_value_and_assert_call():
        fake_func = Mock(return_value='World')
        result = greet(fake_func)

        self.assertEqual(result, 'Hello, World')

        fake_func.assert_called_once()
        fake_func.assert_called_once_with()

    if __name__ == '__main__':
        unittest.main()
        