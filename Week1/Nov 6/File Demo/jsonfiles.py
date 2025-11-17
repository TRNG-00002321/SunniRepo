import json

my_data = {
    "name": "Alice",
    "age": (20,30),
    "city": "New York",
    "isStudent": True,
}
# Open a file in write mode ('w'). If the file doesn't exist, it will be created.
# If it exists it will be overwritten.
def create_json():
    with open("data.json", "w") as file:
        # Dump the Python data into the file in JSON format
        json.dump(my_data, file, indent=4)

def read_json():
    with open("data.json", "r") as file:
        json_data = json.load(file)
        print(json_data)

create_json()
read_json()