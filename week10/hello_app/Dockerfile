# Starte creating an image based on the official Python 3.9 slim image
# From is the instruction that set the base image for subsequent instructions in the Dockerfile
# FROM is the first instruction in a Dockerfile
FROM python:3.9-slim

#set the working directort in the container to /hello_app
WORKDIR /hello_app

# copy the requiremetns.txt file from the host machine to the workinf directory
COPY requirements.txt .

# install the dependencies specified in the requirements.txt file
RUN pip install --no-cache-dir -r requirements.txt

# Copy thr rest of the application code from the host machine to the working directory to the working directory in the container
COPY . .

# Expose port 500 for the application
EXPOSE 5000

# run the application using the command bleow when the container starts
CMD [ "python", "hello.py" ]
