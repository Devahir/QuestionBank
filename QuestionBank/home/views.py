import csv

import random
import os
from django.shortcuts import render,HttpResponse
from django.http import JsonResponse

from home.models import Question
from home.serielizerM import Qestionserializer

def giveRandomQ(request):

    random_num=random.randint(1,24)

    question=Question.objects.get(id=random_num)
    seride=Qestionserializer(question)
    return JsonResponse(seride.data)






# with open('Untitled form.csv') as csvfile:
#     csvReader=csv.DictReader(csvfile)
# Create your views here.
                    # for csvRow in csvReader:

                    # Ques=Question(Class=csvRow['Class'],subject=csvRow['subject'],chapter_name=csvRow['chapter'],Lavel=csvRow['Lavel'],disciption=csvRow['discription'],medium=csvRow['medium'],topic_Key=csvRow['topic_Key'],QuestionText=csvRow['QuestionText'])
                    # Ques.save()

                    # random_num=random.randint(1,12)

                    # Ques=Question(Class=str(random_num),subject="En",chapter_name="grrg",Lavel="rgg",disciption="gorl",medium="wegnw",topic_Key="kjkw",QuestionText="nejfejnfenj")
                    # Ques.save()