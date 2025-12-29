import requests
import pytest

@pytest.fixture(scope='module')
def base_url():
    return 'https://jsonplaceholder.typicode.com/'


@pytest.fixture(scope='module')
def session():
    session = requests.Session()
    session.headers.update({
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    })
    yield session
    session.close()

@pytest.fixture(scope='module')
def sample_post():
    return {
        'title': "Test Post",
        'body': "Test Post Body",
        'userId': 1
    }

class TestBasicsRequest:
    def test_get_single_post(self, base_url, session):
        # response = session.get(base_url/'posts'/1)
        response = session.get(f'{base_url}/posts/1')

        assert response.status_code == 200

        data = response.json()
        assert data['id'] == 1
        assert 'title' in data

    def  test_create_post(self, base_url, session, sample_post):
        response = session.post(f'{base_url}/posts', json=sample_post)
        assert response.status_code == 201

    @pytest.mark.parametrize("userId, expectedName", [
        (1, "Leanne Graham"),
        (2, "Ervin Howell"),
        (3, "Clementine Bauch")
    ])
    def test_get_users_parametrized(self, base_url, session, userId, expectedName):
        response = session.get(f'{base_url}/users/{userId}')
        assert response.status_code == 200

        data = response.json()
        assert data['name'] == expectedName

    @pytest.mark.parametrize('post_id',[1, 2, 3, 4,])
    def test_get_post_by_valid_id(self, base_url, session, post_id):
        response = session.get(f'{base_url}/posts/{post_id}')
        assert response.status_code == 200
    
    @pytest.mark.parametrize('post_id',[-92, 342342, 999,])
    def test_get_post_by_id_invalid(self, base_url, session, post_id):
        response = session.get(f'{base_url}/posts/{post_id}')
        assert response.status_code == 404

    @pytest.mark.parametrize("endpoint,expected_count", [
        ("/posts", 100),
        ("/users", 10),
        ("/comments", 500),
        ("/albums", 100),
        ("/photos", 5000),
        ("/todos", 200)
    ])
    def test_get_with_endpoints(self, base_url, session, endpoint, expected_count):
        response = session.get(f'{base_url}/{endpoint}')
        assert response.status_code == 200
        assert len(response.json()) == expected_count

