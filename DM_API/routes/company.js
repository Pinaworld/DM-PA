const express = require('express');
const bodyParser = require('body-parser');
const controllers = require('../controllers');
const companyController = controllers.CompanyController;


const companyRouter = express.Router();
companyRouter.use(bodyParser.json());

//ADD
companyRouter.post('/', function(req, res) {
  const name = req.body.name;
  const SIREN = req.body.SIREN;
  const city = req.body.city;
  const street = req.body.street;
  const number = req.body.number;
  const zipcode = req.body.zipcode;
  const email = req.body.email;

  companyController.addCompany(name, SIREN, city, street, number, zipcode, email)
  .then((company) => {
    res.status(201).json(company);
  })
  .catch((err) => {
    res.status(500).end();
  });
});

//GET ALL
companyRouter.get('/', function(req,res){
  companyController.getAllCompany()
  .then((companys) => {
    res.status(200).json(companys);
  })
  .catch((err) => {
    console.error(err);
    res.status(500).end();
  })
});

//GET ID
companyRouter.get('/:id' , function(req,res){
  companyController.getCompanyById(req.params.id)
  .then((company) => {
    res.status(201).json(company);
  })
  .catch((err) => {
    console.error(err);
    res.status(500).end();
  })
});

//UPDATE
companyRouter.put('/' , function(req,res){
    const name = req.body.name;
    const SIREN = req.body.SIREN;
    const city = req.body.city;
    const street = req.body.street;
    const number = req.body.number;
    const zipcode = req.body.zipcode;
    const email = req.body.email;
  
    companyController.updateCompany(id, name, SIREN, city, street, number, zipcode, email)
    .then((company) => {
      res.status(200).json(company);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).end();
    })
});

//DELETE
companyRouter.delete('/:id' , function(req,res){
    companyController.deleteCompanyById(req.params.id)
    .then((company) => {
      res.status(204).json(company);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).end();
    })
});

module.exports = companyRouter;
