/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global process */

var mysql = require('mysql');
var express = require('express');
var path = require('path');

var app = express();
var port = process.env.PORT || 8080;

var controller;

app.use( express.static(__dirname + '/public' ));

// sendFile will go here
app.get('/', function(req, res) {
  res.sendFile(path.join('C:/Users/Jasons/Documents/NetBeansProjects/TM470-Project/nbproject/public', '/index.html'));
});

app.listen(port);
console.log('Server started at http://localhost:' + port);

function Controls() {
    alert("Controller loaded!");
}

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "password"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});

