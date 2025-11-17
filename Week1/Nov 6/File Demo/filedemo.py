# Read modes:
#     r - read mode
#     w - create or overwrite mode
#     a - append mode
#     x - create but fails if file exists
#     b - binary mode
#     t - text mode

# Opens a file, reads the entire contents, closes file
def file1():
    file = open("example.txt", "r")
    contents = file.read()
    print(contents)
    file.close()
    print()

# same as file1(), but no need to close file because file is only open in scope of "with"
def file2():
    with open("example.txt", "r") as file:
        contents = file.read()
        print(contents)
    print()

# Reads a single line from the opened file
def read_line():
    with open("example.txt", "r") as file:
        line = file.readline()
        print(line)
    print()

# Reads each line of the file and adds it to a list
def read_lines():
    with open("example.txt", "r") as file:
        lines = file.readlines()
        print(lines)
    print()

def line_iterating():
    with open("example.txt", "r") as file:
        for line in file:
            print(line.strip())
    print()

def read_chunks():
    with open("example.txt", "r") as file:
        while chunk := file.read(1024):
            print(chunk)
    print()
import os
def file_path():
    path = os.path.join("example.txt")
    with open(path, "r") as file:
        print(file.read())
    print()


def write_line():
    with open("example.txt", "w") as file:
        file.write("This is the first line\n")
        file.write("This will overwrite any existing content\n")

def append_line():
    with open("example.txt", "a") as file:
        file.write("This is line has been appended to the file\n")

def create_file():
    try:
        with open("newfile.txt", "x") as file:
            file.write("This is a new file\n")
    except FileExistsError:
        print("File already exists")

def write_lines():
    lines = ["This is line 1\n", "This is line 2\n", "This is line 3\n"]
    with open("multilines.txt", "w") as file:
        file.writelines(lines)

def write_formatted():
    name = "Alice"
    score = 92
    with open("reports.txt", "w") as file:
        file.write(f"Student: {name}\n")
        file.write(f"Score: {score}\n")
# 1. Open file in write mode in binary
# 2. write data to file
def write_binary():
    data = bytes([120, 3, 255, 0, 100])
    with open("binary.dat", "wb") as file:
        file.write(data)




def main():
    file1()
    file2()
    read_line()
    read_lines()
    line_iterating()
    read_chunks()
    write_line()
    append_line()
    create_file()
    write_lines()
    write_formatted()
    write_binary()

main()