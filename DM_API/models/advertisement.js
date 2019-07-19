'use strict';

module.exports = function(sequelize , DataTypes){

const Advertisement = sequelize.define('Advertisement', {

        advertisementId: {
            type: DataTypes.BIGINT,
            primaryKey: true,
            autoIncrement: true
        },
        availabilityDate:{
            type: DataTypes.DATE,
            allowNull: false
        },
        large: {
            type: DataTypes.INTEGER,
            allowNull: false
        },
        medium: {
            type: DataTypes.INTEGER,
            allowNull: false
        },
        small: {
            type: DataTypes.INTEGER,
            allowNull: false
        },
    },
    {
        paranoid: false,
        underscored: true,
        freezeTableName: true
    });
    
    Advertisement.associate = (models) => {
        Advertisement.belongsTo(models.Company, {
          foreignKey: 'companyId',
          onDelete: 'CASCADE',
        });
      };

    return Advertisement;
};


