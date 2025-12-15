class User:
    def __init__(self, user_id, username, email, role):
        self.user_id = user_id
        self.username = username
        self.email = email
        self.role = role
    def __init__(self, username, email):
        self.username = username
        self.email = email     

    def __init__(self, **kwargs):
        self.user_id = kwargs.get("user_id")
        self.username = kwargs.get("username")
        self.email = kwargs.get("email")
        self.role = kwargs.get("role")           


class DatabaseConnection:
    def __init__(self, host, port):
        self.host = host
        self.port = port
    def connect():
        return 'CONNECTED'
    def disconnect():
        return 'DISCONNECTED'
    def load_test_data():
        return 'LOADED'
    def save():
        return 'SAVED'
    def delete():
        return 'DELETED'
    def create_session(user):
        return 'SESSION CREATED'
