import requests
import json

import csv
import os

#"Timestamp","Class","subject","chapter","Lavel","discription","medium","topic_Key","QuestionText"

def post_data():

    with open('dev.csv') as csvfile:
        csvReader=csv.DictReader(csvfile)

        for csvRow in csvReader:
            if csvRow['Class']=="8":
                data = {'Class':csvRow['Class'], 'subject':csvRow['subject'], 'chapter_name': csvRow['chapter'], 'Lavel': csvRow['Lavel'], 'disciption': csvRow['discription'], 'medium': csvRow['medium'], 'topic_Key':csvRow['topic_Key'], 'QuestionText': csvRow['QuestionText']}
            
    json_data = json.dumps(data)
    r = requests.post(url="http://127.0.0.1:8000/q", data=json_data)
    data = r.json()
    return data
print(post_data())