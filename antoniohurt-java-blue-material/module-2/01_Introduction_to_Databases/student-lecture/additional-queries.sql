-- The name and population of all cities in the USA with a population of greater than 1 million people

-- The name and population of all cities in China with a population of greater than 1 million people

-- The name and region of all countries in North or South America
  
-- The name, continent, and head of state of all countries whose form of government is a monarchy

-- The name, country code, and population of all cities with a population less than one thousand people

-- The name and region of all countries in North or South America except for countries in the Caribbean
SELECT name, region FROM country WHERE continent IN ('North America', 'South America') and region != 'Caribbean';

-- The name, population, and GNP of all countries with a GNP greater than $1 trillion dollars and a population of less than 1 billion people
SELECT name, population, gnp FROM country WHERE gnp > 100000 AND population < 1000000000;
-- The name and population of all cities in Texas that have a population of greater than 1 million people

-- The name and average life expectancy of all countries in southern regions

-- The name and average life expectancy of all countries in southern regions for which an average life expectancy has been provided (i.e. not equal to null)

-- The name, continent, GNP, and average life expectancy of all countries in Africa or Asia that have an average life expectancy of at least 70 years and a GNP between $1 billion and $100 billion dollars
SELECT name, continent, GNP, lifeexpectancy FROM country WHERE continent IN ('Africa', 'Asia') AND lifeexpectancy >= 70 AND (gnp > 1000 AND gnp < 100000);