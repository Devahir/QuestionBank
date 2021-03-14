from rest_framework import serializers
from .models import Question

class Studentserializer(serializers.Serializer):
    first_name=serializers.CharField(max_length=30)
    last_name=serializers.CharField(max_length=30)
    Stud_class=serializers.CharField(max_length=4)
    medium=serializers.CharField(max_length=3)
    course=serializers.CharField(max_length=4)
    coin=serializers.CharField(max_length=4)
    weight=serializers.CharField(max_length=4)

class Qestionserializer(serializers.Serializer):
    Class=serializers.CharField(max_length=3)
    subject=serializers.CharField(max_length=4)
    chapter_name=serializers.CharField(max_length=40)
    Lavel=serializers.CharField(max_length=4)
    disciption=serializers.CharField(max_length=50)
    medium=serializers.CharField(max_length=3)
    topic_Key=serializers.CharField(max_length=40)
    QuestionText=serializers.CharField(max_length=1000)
    
    def create(self, validated_data):
        return Question.objects.create(**validated_data)