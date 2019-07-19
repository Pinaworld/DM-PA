const express = require('express');
const bodyParser = require('body-parser');
const controllers = require('../controllers');
const advertisementController = controllers.AdvertisementController;


const advertisementRouter = express.Router();
advertisementRouter.use(bodyParser.json());

//ADD
advertisementRouter.post('/', function(req, res) {
   const availabilityDate = req.body.availabilityDate;
   const large = req.body.lastName;
   const medium = req.body.zipcode;
   const small = req.body.city;
   const idCompany = req.params.idCompany;

  advertisementController.addAdvertisement(availabilityDate, large, medium, small, idCompany)
  .then((advertisement) => {
    res.status(201).json(advertisement);
  })
  .catch((err) => {
    res.status(500).end();
  });
});

//GET ALL
advertisementRouter.get('/', function(req,res){
  advertisementController.getAllAdvertisement()
  .then((advertisements) => {
    res.status(200).json(advertisements);
  })
  .catch((err) => {
    console.error(err);
    res.status(500).end();
  })
});

//GET ID
advertisementRouter.get('/:id' , function(req,res){
  advertisementController.getAdvertisementById(req.params.id)
  .then((advertisement) => {
    res.status(201).json(advertisement);
  })
  .catch((err) => {
    console.error(err);
    res.status(500).end();
  })
});

//UPDATE
advertisementRouter.put('/' , function(req,res){
    
    const idAdvertisement = req.body.idAdvertisement;
    const availabilityDate = req.body.availabilityDate;
    const large = req.body.lastName;
    const medium = req.body.zipcode;
    const small = req.body.city;
    const idCompany = req.params.idCompany;
  
    advertisementController.updateAdvertisement(idAdvertisement, availabilityDate, large, medium, small, idCompany)
    .then((advertisement) => {
      res.status(200).json(advertisement);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).end();
    })
});

//DELETE
advertisementRouter.delete('/:id' , function(req,res){
    advertisementController.deleteAdvertisementById(req.params.id)
    .then((advertisement) => {
      res.status(204).json(advertisement);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).end();
    })
});

module.exports = advertisementRouter;
