from django.contrib import admin
from django.urls import path
from home import views

urlpatterns = [
    path('q', views.giveRandomQ,name='home'),
]