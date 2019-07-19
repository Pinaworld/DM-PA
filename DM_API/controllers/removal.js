const ModelIndex = require('../models');
const Removal = ModelIndex.Removal;

const RemovalController = function() {};

//ADD
RemovalController.addRemoval = function(date, address, arrivalAddress){
  return Removal.create({
    date: date,
    address: address,
    arrivalAddress: arrivalAddress
  });
};

//GET ALL
RemovalController.getAllRemoval = function(){
  return Removal.findAll()
  .catch((err) => {
    console.error(err);
  });
};

//GET ID
RemovalController.getRemovalById = function(removalId){
  return Removal.find({
    where: {
      id: removalId
    }
  })
  .then((removal) => {
    console.log('Déménagement trouvé');
    return removal;
  })
  .catch((error) => {
    console.error(err);
  });
};


//UPDATE
RemovalController.updateRemoval = function(id, newDate, newAddress, newArrivalAddress) {
    const removal = Removal.find({
        where:{
            id: id
        }
    });
    
    if(removal === undefined){
        return;
    }
    
    if(newDate === undefined) {
        newDate = removal.date;
    }
    
    if(newAddress === undefined) {
        newAddress = removal.address;
    }
    
    if(newArrivalAddress === undefined) {
        newArrivalAddress = removal.arrivalAddress;
    }
    
    removal.updateAttributes({
        date: newDate,
        address: newAddress,
        arrivalAddress: newArrivalAddress
    });
    
    return removal;
};

//DELETE
RemovalController.deleteRemovalById = function(idRemoval){
  return Removal.destroy({
    where:{
      id: idRemoval
    }
  })
  .then(() => {
      console.log("Le déménagement à été supprimé.");
    })
    .catch((err) => {
      console.error(err);
    });
};

module.exports = RemovalController;
