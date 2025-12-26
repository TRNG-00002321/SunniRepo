import requests
import pytest
def test_get_user():
    response = requests.get('https://jsonplaceholder.typicode.com/users/1')
    print(response.status_code)
    print(response.json())
    print(response.text)
    
    assert response.status_code == 200

def test_get_comment_with_params():
    params = {
        "postId" : 1
    }
    response = requests.get('https://jsonplaceholder.typicode.com/comments', params=params)

    assert response.status_code == 200

def test_post_with_json():
    post_data = {
        "userId": 1,
        "title" : "This Is The Title",
        "body" : "This is the body."
    }

    response = requests.post('https://jsonplaceholder.typicode.com/posts', json=post_data)

    assert response.status_code == 201

def test_get_post_with_invalid_id():
    try:
        response = requests.get('https://jsonplaceholder.typicode.com/posts/999')
        response.raise_for_status()
    except requests.exceptions.HTTPError as e:
        print(f'\n   HTTP Error: {e}')
    # assert response.status_code == 404
