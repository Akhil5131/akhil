#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jul 26 21:37:45 2022

@author: akhil
"""

from ast import literal_eval
import pandas as pd
import pymongo
from flask import Flask, request

app = Flask(__name__)
mongo = pymongo.MongoClient(host='localhost', port=27017, serverSelectionTimeoutMS=1000)
mongo.server_info()

db = mongo.database
collection = db['netflix']
dataset = pd.read_csv("/Users/akhil/Downloads/Netflix.csv")
dataset['title'] = dataset['title'].str.upper()
dataset['genres'] = dataset['genres'].map(literal_eval)
dataset['production_countries'] = dataset['production_countries'].map(literal_eval)
collection.insert_many(dataset.to_dict(orient='records'))


# Insert the new movie and show
@app.route('/api', methods=['POST'])
def postNewMovie():
    if request.method == "POST":
        newMovie = request.get_json()
        newMovie['title'] = str(newMovie['title']).lower()
        newMovie['genres'] = literal_eval(str(newMovie['genres']))
        newMovie['production_countries'] = literal_eval(str(newMovie['production_countries']))
        collection.insert_one(newMovie)
        return {"status": "SUCCESS", "errorMessages": "", "action": "POST"}


# Update the movie and show
@app.route('/api/<string:title>', methods=['PATCH'])
def patchMovie(title):
    if request.method == "PATCH":
        movieData = request.get_json()
        collection.update_many({"title": title.lower()}, {"$set": {"description": movieData['description'],
                                                                   "imdb_score": movieData['imdb_score']}})
        return {"status": "SUCCESS", "errorMessages": "", "action": "PATCH"}


# Delete the movie and show information using title
@app.route('/api/<string:title>', methods=['DELETE'])
def deleteMovie(title):
    if request.method == "DELETE":
        collection.delete_many({"title": title.lower()})
        return {"status": "SUCCESS", "errorMessages": "", "action": "DELETE"}


# Retrieve all the movies and shows in database
@app.route('/api', methods=['GET'])
def getMovie():
    if request.method == "GET":
        return {"movies": list(collection.find({}, {"_id": 0}))}


# Display the movie and show’s detail using title
@app.route('/api/<string:title>', methods=['GET'])
def getMovieDetail(title):
    if request.method == "GET":
        return {"movies": list(collection.find({"title": title.lower()}, {"_id": 0}))}


if __name__ == "__main__":
    app.run()

    