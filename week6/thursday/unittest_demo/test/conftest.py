import pytest

@pytest.fixture(scope="module")
def sample_data():
    return {'name':'Alex', 'age':22}
