const ModelIndex = require('../models');
const Advertisement = ModelIndex.Advertisement;

const AdvertisementController = function() {};

//ADD
AdvertisementController.addAdvertisement = function(availabilityDate, large, medium, small, idCompany){
  return Advertisement.create({
    availabilityDate: availabilityDate,
    large: large,
    medium: medium,
    small: small,
    idCompany: idCompany
  });
};

//GET ALL
AdvertisementController.getAllAdvertisement = function(){
  return Advertisement.findAll()
  .catch((err) => {
    console.error(err);
  });
};

//GET ID
AdvertisementController.getAdvertisementById = function(advertisementId){
  const advertisement =  Advertisement.find({
    where: {
      id: advertisementId
    }
  })
  .then((advertisement) => {
    console.log('Annonce trouvée');
    return advertisement;
  })
  .catch((error) => {
    console.error(err);
  });
};


//UPDATE
AdvertisementController.updateAdvertisement = function(newAvailabilityDate, newLarge, newMedium, newSmall, idCompany) {
    const advertisement = Advertisement.find({
        where:{
            id: id,
            idCompany: idCompany
        }
    });
    
    if(advertisement === undefined){
        return;
    }
    
    if(newAvailabilityDate === undefined) {
        newAvailabilityDate = advertisement.availabilityDate;
    }
    
    if(newLarge === undefined) {
        newLarge = advertisement.large;
    }
    
    if(newMedium === undefined) {
        newMedium = advertisement.medium;
    }

    if(newSmall === undefined) {
        newSmall = advertisement.small;
    }

    advertisement.updateAttributes({
        availabilityDate: availabilityDate,
        large: large,
        medium: medium,
        small: small
    });
    
    return advertisement;
};

//DELETE
AdvertisementController.deleteAdvertisementById = function(idAdvertisement){
  return Advertisement.destroy({
    where:{
      id: idAdvertisement
    }
  })
  .then(() => {
      console.log("L'annonce à été supprimée.");
    })
    .catch((err) => {
      console.error(err);
    });
};

module.exports = AdvertisementController;
