import json


with open('questions.json') as file:
    questions = json.load(file)
user_answers = {}

for question in questions.keys():
    print(question)
    user_answer = input("> ")
    user_answers[question] = user_answer.lower()
score = 0
for question, answer in questions.items():
    if user_answers[question] == answer:
        score += 1

print(f"Final Score: {score}/{len(questions)}")
