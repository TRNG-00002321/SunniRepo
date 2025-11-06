# Create a python program that create a string as " Hello World "
# Use common string methods like lower() upper() strip() lstrip() rstrip() replace() split() join() find() index()

def hello_world():
    hello = "h".upper() + "E".lower() + "   ll   ".strip() + "   o".lstrip()
    world = "t".replace("t", "W") + "o, r, l, d".split(",")[0] + "rld    ".rstrip()
    result = " ".join([hello, world])
    result = result.center(13)
    print(result)

hello_world()
