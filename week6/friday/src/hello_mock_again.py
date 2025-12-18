from unittest.mock import Mock

mock = Mock()

mock.api.return_value={'id':1, 'name': 'Sunni'}

# Calls the api
print(mock.api)

# Calls api function
print(mock.api())
