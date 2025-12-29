from unittest.mock import Mock

# Create Mock
weather_api = Mock()

# Configuring the Mock to return a value
weather_api.get_tempurature('Plano').return_value = 25

# Use a Mock
temp = weather_api.get_temperature('Plano')
print(temp)

#Verify the method get_tempurature() was called
weather_api.assert_called_once_with('Plano')
