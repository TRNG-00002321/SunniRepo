import pandas as pd
from datetime import date
class Database:
    def __init__(self):
        self.user_df = pd.read_csv("users.csv")
        self.user_df["isManager"] = self.user_df["isManager"].astype(bool)

        self.expenses_df = pd.read_csv("expenses.csv")
        self.expenses_df.set_index("id", inplace=True)



    def validate_user(self, username, password):
        users = self.user_df.loc[(self.user_df['username'] == username) & (self.user_df['password'] == password)]
        if not users.empty:
            return True
        return False


    def add(self, new_date, amount, category, description):
        new_date = new_date.split("-")
        year, month, day = [int(x) for x in new_date]
        entry = pd.Series({"id": self.expenses_df.shape[0], "date": date(year, month, day).__str__(), "amount": amount, "category": category, "description": description})
        self.expenses_df = pd.concat([self.expenses_df, entry.to_frame().T])
        self.view()

    def view(self):
        print(self.expenses_df.to_string())
        print()

    def update(self, index, new_date, amount, category, description):
        new_date = new_date.split("-")
        year, month, day = [int(x) for x in new_date]
        self.expenses_df.loc[index] = [date(year, month, day).__str__(), amount, category, description]
        self.view()

    def close(self):
        self.expenses_df.to_csv("expenses.csv")


