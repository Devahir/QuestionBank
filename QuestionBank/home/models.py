from django.db import models

# Create your models here.

class Question(models.Model):
    Class=models.CharField(max_length=3)
    subject=models.CharField(max_length=4)
    chapter_name=models.CharField(max_length=40)
    Lavel=models.CharField(max_length=4)
    disciption=models.CharField(max_length=50)
    medium=models.CharField(max_length=3)
    topic_Key=models.CharField(max_length=40)
    QuestionText=models.CharField()

class Student(models.Model):
    first_name=models.CharField(max_length=30)
    last_name=models.CharField(max_length=30)
    Stud_class=models.CharField(max_length=4)
    medium=models.CharField(max_length=3)
    course=models.CharField(max_length=4)
    coin=models.CharField(max_length=4)
    weight=models.CharField(max_length=4)