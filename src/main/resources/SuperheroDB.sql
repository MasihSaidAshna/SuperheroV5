-- Opret database
CREATE DATABASE superpower_hero_city;

-- Brug database
USE superpower_hero_city;

-- Opret tabeller
CREATE TABLE Superpower (
    superpowerID INT NOT NULL PRIMARY KEY,
    superpowerName VARCHAR(50) NOT NULL
);

CREATE TABLE Superhero (
    superheroID INT NOT NULL PRIMARY KEY,
    heroName VARCHAR(50) NOT NULL,
    realName VARCHAR(50) NOT NULL,
    creationYear INT NOT NULL
);

CREATE TABLE City (
    cityID INT NOT NULL PRIMARY KEY,
    cityName VARCHAR(50) NOT NULL
);

CREATE TABLE Superhero_Superpower (
    superheroID INT NOT NULL,
    superpowerID INT NOT NULL,
    PRIMARY KEY (superheroID, superpowerID),
    FOREIGN KEY (superheroID) REFERENCES Superhero(superheroID),
    FOREIGN KEY (superpowerID) REFERENCES Superpower(superpowerID)
);

CREATE TABLE City_Superhero (
    cityID INT NOT NULL,
    superheroID INT NOT NULL,
    PRIMARY KEY (cityID, superheroID),
    FOREIGN KEY (cityID) REFERENCES City(cityID),
    FOREIGN KEY (superheroID) REFERENCES Superhero(superheroID)
);

-- Tilføj testdata
INSERT INTO Superpower (superpowerID, superpowerName) VALUES
(1, 'Flyvning'),
(2, 'Usynlighed'),
(3, 'Superstyrke');

INSERT INTO Superhero (superheroID, heroName, realName, creationYear) VALUES
(1, 'Superman', 'Clark Kent', 1938),
(2, 'Batman', 'Bruce Wayne', 1939),
(3, 'Spider-Man', 'Peter Parker', 1962);

INSERT INTO City (cityID, cityName) VALUES
(1, 'Metropolis'),
(2, 'Gotham City'),
(3, 'New York City');

INSERT INTO Superhero_Superpower (superheroID, superpowerID) VALUES
(1, 1),
(1, 3),
(2, 2),
(2, 3),
(3, 1),
(3, 3);

INSERT INTO City_Superhero (cityID, superheroID) VALUES
(1, 1),
(2, 2),
(3, 3),
(3, 2);