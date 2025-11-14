
import pandas as pd

expenses = pd.read_csv("expenses.csv", )
users = pd.read_csv("users.csv")
users["isManager"] = users["isManager"].astype(bool)


