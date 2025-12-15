import pytest

def test_user_has_correct_email(user):
    assert user.email == 'test@example.com'

def test_admin_has_admin_role(admin_user):
    assert admin_user.role == 'admin'
