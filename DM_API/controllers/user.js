const ModelIndex = require('../models');
const User = ModelIndex.User;

const UserController = function() {};

UserController.addUser = function(firstName, lastName, zipcode, city, email, password){
  return User.create({
    firstName: firstName,
    lastName: lastName,
    zipcode: zipcode,
    city: city,
    email: email,
    password: password
  });
};

UserController.deleteUser = function(idUser){
  return User.destroy({
    where:{
      id: idUser
    }
  })
  .then(() => {
      console.log("L'utilisateur à été supprimé.");
    })
    .catch((err) => {
      console.error(err);
    })
};

UserController.updateUser = function(idUser, newFirstName, newLastName, newZipcode, newCity, newEmail, newPassword) {
  const user = User.find({
    where:{
      id: idUser
    }
  });

  if(newFirstName === undefined) {
    newFirstName = advertisement.firstName;
}

if(newLastName === undefined) {
    newLastName = advertisement.newLastName;
}

if(newZipcode === undefined) {
    newZipcode = advertisement.newZipcode;
}

if(newCity === undefined) {
    newCity = advertisement.city;
}

if(newPassword === undefined) {
    newPassword = advertisement.password;
}

if(newEmail === undefined) {
    newEmail = advertisement.email;
}

  user.updateAttributes({
    firstName: newFirstName,
    lastName: newLastName,
    zipcode: newZipcode,
    city: newCity,
    email: newEmail,
    password: newPassword
  });

  return user;
};

UserController.getUserById = function(userId){
  return User.find({
    where: {
      id: userId
    }
  })
  .then((user) => {
    console.log('Utilisateur trouvé');
    return user;
  })
  .catch((error) => {
    console.error(err);
  });
};

UserController.getAllUser = function(){
  return User.findAll()
  .catch((err) => {
    console.error(err);
  });
};


UserController.login = function(email, password){
  return User.find({
    where : {
      email : email,
      password : password
    }
  })
  .then((user)=>{
    if(user){
      return user;
    }
    else{
      return null;
    }
  });
};

module.exports = UserController;
