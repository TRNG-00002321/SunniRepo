import pytest
import sys
import platform

@pytest.mark.skip(reason='Feature not implemented')
def test_future_feature():
    from myapp import future_feature
    assert future_feature() == 'working'

@pytest.mark.skip(reason='Broke after refactoring, fix in JIRA-123')
def test_broken_after_refactor():
    assert False

@pytest.mark.skipif(
    sys.platform != 'win32',
    reason="Windows specific functionality"
)
def test_windows_registry():
    import winreg
    assert True
@pytest.mark.skipif(
    sys.platform != 'linux',
    reason='Linux specific functionality'
)
def test_linux_permision():
    import pwd
    assert True

@pytest.mark.skipif(
sys.platform != "darwin",
reason="macOS-specific functionality"
)
def test_macos_keychain():
    """Test macOS Keychain access."""
    # macOS-specific test code
    assert True

@pytest.mark.skipif(
    platform.machine() != "x86_64",
    reason="Requires x86_64 architecture"
)
def test_x86_specific():
    """Test that requires specific CPU architecture."""
    assert True

@pytest.mark.skipif(
    sys.version_info < (3, 10),
    reason='Required Python 3.10+ for match statement'
)
def test_maatch_statement():
    value = 'test'
    match value:
        case 'test':
            result = True
        case _:
                result = False
    assert result

@pytest.mark.skipif(
    sys.version_info >= (3, 12),
    reason = 'Deprecated in Python 3.12'
)
def test_deprecated_feature():
    assert True

requires_pyton_310 = pytest.mark.skipif(
    sys.version_info < (3, 10),
    reason='Requires Python 3.10+'
)
@requires_pyton_310
def test_another_310_feature():
    assert True

try:
    import pandas
    HAS_PANDAS = True
except ImportError:
    HAS_PANDAS = False

try:
    import numpy
    HAS_NUMPY = True
except ImportError:
    HAS_NUMPY = False

@pytest.mark.skipif(not HAS_PANDAS, reason='pandas not installed')
def test_dataframe_operations():
    import pandas as pd
    df = pd.DataFrame({"a": [1, 2, 3]})
    assert len(df) == 3

@pytest.mark.skipif(not HAS_NUMPY, reason='numpy not installed')
def test_numpy_operations():
    import numpy as np
    arr = np.array([1, 2, 3])
    assert arr.sum() == 6

def test_with_importorskip():
    request = pytest.importorskip('requests')
    response = requests.get("https://httpbin.org/get")
    assert response.status_code == 200

@pytest.mark.xfail(reason='Known bug, fix in progress')
def test_known_bug():
    assert 1 + 1 == 3

@pytest.mark.xfail(
    strict = True,
    reason='This MUST fail, if it passes something is wrong'
)
def test_strict_xfail():
    assert False

@pytest.mark.xfail(
    sys.platform == "win32", 
    reason='Flaky on windows'
)
def test_flaky_on_windows():
    import random
    assert random.choice([True, True, True, False])

@pytest.mark.xfail(raises=ZeroDivisionError)
def test_specific_exception():
    1/0
