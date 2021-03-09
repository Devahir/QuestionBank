from django.shortcuts import render,HttpResponse
from django.http import JsonResponse

# Create your views here.

def giveRandomQ(request):
    return JsonResponse({'Question':'solutions'})

