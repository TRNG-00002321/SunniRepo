import mysql.connector

class MyDBConnection:
    @staticmethod
    def get_connection():
        conn = mysql.connector.connect(
            host="localhost",
            user="root",
            passwd="password",
            database="mydb2")
        return conn



# get_all_users()
# insert_user(873242, "Ellen", "ellen@email.com")
# get_all_users()


