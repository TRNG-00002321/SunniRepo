
import model
from util.mydb_connection import MyDBConnection

class UserMysqlImpl:

    def __init__(self):
        self.connection = MyDBConnection.get_connection()
        self.cursor = self.connection.cursor()

    def get_all_users(self):
        self.cursor.execute("SELECT * FROM users")
        rows = self.cursor.fetchall()
        for row in rows:
            print(row)
        print()

    def insert_user(self, user:model.User):
        self.cursor.execute("INSERT INTO users VALUES (%s, %s, %s)", (user.get_id(), user.get_name(), user.get_email()))
        self.connection.commit()