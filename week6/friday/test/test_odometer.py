import unittest
from unittest.mock import Mock
import src.odometer as odometer

class TestOdometer(unittest.TestCase):

    def test_alert_lower_bound(self):
        odometer.speed = Mock()
        odometer.speed.return_value = 70
        self.assertFalse(odometer.alert())
