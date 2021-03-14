from django.contrib import admin
from .models import Student,Question

# Register your models here.

class ques(admin.ModelAdmin):
    list_display=["first_name","Stud_class"]


admin.site.register(Student,ques)

class qq(admin.ModelAdmin):
    list_display=["chapter_name","topic_Key"]

admin.site.register(Question,qq)
