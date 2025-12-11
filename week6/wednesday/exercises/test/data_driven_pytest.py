import pytest
import json
from pathlib import Path

@pytest.fixture(scope='session')
def load_json():
    file_path = Path(__file__) / "test_data" / 'calculator_test.csv'
    with open(file_path, newline='') as f:
        return json.load(f)
    
@pytest.fixture(scope='module')
def data(load_json):
