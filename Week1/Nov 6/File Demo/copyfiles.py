# Assignment
# 1. Write a python file to copy one file into another
# 2. Write a python script to copy an image

def copy_file(file_name):
    with open(file_name, "rb") as file_r:
        with open(file_name.replace(".", "_copy."), "wb") as file_w:
            file_w.write(file_r.read())
    print(f"{file_name} copied successfully")

def main():
    copy_file("example.txt")
    copy_file("dog.jpg")

main()

