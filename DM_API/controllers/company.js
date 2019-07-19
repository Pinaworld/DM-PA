const ModelIndex = require('../models');
const Company = ModelIndex.Company;

const CompanyController = function() {};

//ADD
CompanyController.addCompany = function(name, SIREN, city, street, number, zipcode, email){
  return Company.create({
    name: name,
    SIREN: SIREN,
    city: city,
    street: street,
    number: number,
    zipcode: zipcode,
    email: email
  });
};

//GET ALL
CompanyController.getAllCompany = function(){
  return Company.findAll()
  .catch((err) => {
    console.error(err);
  });
};

//GET ID
CompanyController.getCompanyById = function(companyId){
  return Company.find({
    where: {
      id: companyId
    }
  })
  .then((company) => {
    console.log('Déménagement trouvé');
    return company;
  })
  .catch((error) => {
    console.error(err);
  });
};


//UPDATE
CompanyController.updateCompany = function(id, name, SIREN, city, street, number, zipcode, email) {
    const company = Company.find({
        where:{
            id: id
        }
    });
    
    if(company === undefined){
        return;
    }
    
    if(newName === undefined) {
        newName = company.name;
    }
    
    if(newSIREN === undefined) {
        newSIREN = company.SIREN;
    }
    
    if(newCity === undefined) {
        newCity = company.city;
    }
    
    if(newStreet === undefined) {
        newStreet = company.street;
    }

    if(newNumber === undefined) {
        newNumber = company.number;
    }

    if(newZipcode === undefined) {
        newZipcode = company.zipcode;
    }

    if(newEmail === undefined) {
        newEmail = company.email;
    }
    company.updateAttributes({
        name: name,
        SIREN: SIREN,
        city: city,
        street: street,
        number: number,
        zipcode: zipcode,
        email: email
    });
    
    return company;
};

//DELETE
CompanyController.deleteCompanyById = function(idCompany){
  return Company.destroy({
    where:{
      id: idCompany
    }
  })
  .then(() => {
      console.log("Le déménagement à été supprimé.");
    })
    .catch((err) => {
      console.error(err);
    });
};

module.exports = CompanyController;
