import pytest
from src.models import User, DatabaseConnection

@pytest.fixture
def user():
    return User(
        user_id = 1,
        username = 'testuser', 
        email = 'test@example.com',
        role = 'user'
    )

@pytest.fixture
def admin_user():
    return User(
        user_id = 99,
        username = 'adminuser',
        email= 'admin@example.com',
        role = 'admin'
    )

@pytest.fixture(scope='session')
def database():
    """
    Database connection shared resource accross all test in the session.
    Expensive to create, so reuse it.
    """
    print('\n[SETUP] Creating database conneciton')
    db = DatabaseConnection(host='localhost', port=5432)
    print(db.connect())
    yield database

    # Teardown: runs after all tests
    print('\n[TEARDOWN] Closing database connection')
    print(db.disconnect())
    
@pytest.fixture(scope='module')
def test_data(database):
    """
    TEST data loaded once per module.
    Depends on database fixture
    """
    print('\n{SETUP] Loading Test Data}')
    data = database.load_test_data()

    yield data
    print('\n[TEARDOWN] Clearing test data')
    database.clear_test_data()

@pytest.fixture(scope='function')
def fresh_user(database):
    user = User(username='fresh_user', email='fresh@example.com', role="example")
    database.save(user)

    yield user

    database.delete(user)

@pytest.fixture
def authenticated_user(user, database):
    session= database.create_session(user)
    user.session = session
    database.end_session(session)

@pytest.fixture
def user_with_orders(authenticated_user, database):
    orders = [
        {'id' : 1, 'product':'Laptop', 'amount':999.99},
        {'id' : 2, 'product':'Moutse', 'amount':29.99}
    ]
    for order in orders:
        database.create_order(authenticated_user.id, order)
    yield authenticated_user

    database.delete_orders_for_user(authenticated_user.id)

@pytest.fixture(params=['user', 'admin', 'guest'])
def user_role(request):
    return request.param

@pytest.fixture(params=[
    pytest.param(User(username = 'alice', email = 'alice@test.com'), id='alice'),
    pytest.param(User(username = 'bob', email = 'bob@test.com'), id='bob'),
    pytest.param(User(username = 'charlie', email = 'charlie@test.com'), id='charlie'),
])
def sample_user(request):
    return request.param
