import unittest

class TestStringMethods(unittest.TestCase):
    def test_isUpper(self):
        self.assertEqual('foo'.upper(), 'FOO')
        