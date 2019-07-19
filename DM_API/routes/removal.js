const express = require('express');
const bodyParser = require('body-parser');
const controllers = require('../controllers');
const removalController = controllers.RemovalController;


const removalRouter = express.Router();
removalRouter.use(bodyParser.json());

//ADD
removalRouter.post('/', function(req, res) {
  const date = req.body.date;
  const address = req.body.address;
  const arrivalAddress = req.body.arrivalAddress;

  removalController.addRemoval(date, address, arrivalAddress)
  .then((removal) => {
    res.status(201).json(removal);
  })
  .catch((err) => {
    res.status(500).end();
  });
});

//GET ALL
removalRouter.get('/', function(req,res){
  removalController.getAllRemoval()
  .then((removals) => {
    res.status(200).json(removals);
  })
  .catch((err) => {
    console.error(err);
    res.status(500).end();
  })
});

//GET ID
removalRouter.get('/:id' , function(req,res){
  removalController.getRemovalById(req.params.id)
  .then((removal) => {
    res.status(201).json(removal);
  })
  .catch((err) => {
    console.error(err);
    res.status(500).end();
  })
});

//UPDATE
removalRouter.put('/' , function(req,res){
    const id = req.body.id;
    const newDate = req.body.date;
    const newAddress = req.body.address;
    const newArrivalAddress = req.body.arrivalAddress;
  
    removalController.updateRemoval(id, newDate, newAddress, newArrivalAddress)
    .then((removal) => {
      res.status(200).json(removal);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).end();
    })
});

//DELETE
removalRouter.delete('/:id' , function(req,res){
    removalController.deleteRemovalById(req.params.id)
    .then((removal) => {
      res.status(204).json(removal);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).end();
    })
});

module.exports = removalRouter;
