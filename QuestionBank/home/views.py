import csv

import random
import os
import io
from django.shortcuts import render,HttpResponse
from django.http import JsonResponse

from rest_framework.parsers import JSONParser
from rest_framework.renderers import JSONRenderer

from home.models import Question
from home.serielizerM import Qestionserializer
from django.views.decorators.csrf import csrf_exempt

@csrf_exempt
def giveRandomQ(request):

    if request.method=="GET":
        res={"msg":"Not"}
        random_num=random.randint(1,24)
        for x in range(1,30):
            question=Question.objects.get(id=x)
            # question.delete()
            res={"msg":"ataeCDa rted"}
        json_data=JSONRenderer().render(res)
        return JsonResponse({'data':json_data})

    if request.method=="POST":
        json_data=request.body
        stream=io.BytesIO(json_data)
        pythondata=JSONParser().parse(stream)
        serializer=Qestionserializer(data=pythondata)
        if serializer.is_valid():
            serializer.save()
            res={"msg":"Data Created"}
            json_data=JSONRenderer().render(res)
            return HttpResponse(json_data,content_type="application/json")
        json_data=JSONRenderer().render(serializer.errors)
        return HttpResponse(json_data,content_type="application/json")







# question=Question.objects.filter(Class="7")
# with open('Untitled form.csv') as csvfile:
#     csvReader=csv.DictReader(csvfile)
# Create your views here.
                    # for csvRow in csvReader:

                    # Ques=Question(Class=csvRow['Class'],subject=csvRow['subject'],chapter_name=csvRow['chapter'],Lavel=csvRow['Lavel'],disciption=csvRow['discription'],medium=csvRow['medium'],topic_Key=csvRow['topic_Key'],QuestionText=csvRow['QuestionText'])
                    # Ques.save()

                    # random_num=random.randint(1,12)

                    # Ques=Question(Class=str(random_num),subject="En",chapter_name="grrg",Lavel="rgg",disciption="gorl",medium="wegnw",topic_Key="kjkw",QuestionText="nejfejnfenj")
                    # Ques.save()