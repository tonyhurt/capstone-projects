-- Write queries to return the following:
-- Make the following changes in the "world" database.
select * from countrylanguage
where countrycode = 'USA';

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
insert into city(name, district, countrycode, population)
values ('Smallville', 'Kansas', 'USA', 45001);

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
insert into countrylanguage(countrycode, language, percentage, isofficial)
values ('USA', 'Kryptonese', 0.0001, false);

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
update countrylanguage 
set language = 'Krypto-babble'
where language = 'Kryptonese';

-- 4. Set the US captial to Smallville, Kansas in the country table. 4080
select * from country
where code = 'USA';

update country
set capital = 4080
where code = 'USA';

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
delete from city
where name = 'Smallville' and district = 'Kansas';
--Did not succeed, because it violates a foreign key constraint

-- 6. Return the US captial to Washington.
UPDATE country
set capital = 3813
where code = 'USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE FROM city
WHERE name = 'Smallville' and district = 'Kansas';
--yes, because there is no other table reliant on that data.

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
UPDATE countrylanguage
SET isofficial = true
WHERE isofficial = false and countrycode in
        (select code
        from country
        where indepyear > 1800 AND indepyear < 1972);

UPDATE countrylanguage
SET isofficial = false
WHERE isofficial = true and countrycode in
        (select code
        from country
        where indepyear > 1800 AND indepyear < 1972);
        
        select * from countrylanguage;


-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
SELECT * FROM city;
UPDATE city
SET population = (population / 1000);

-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
SELECT * FROM country;
UPDATE country
SET surfacearea = (surfacearea * 1609)
WHERE code IN (SELECT countrycode
FROM countrylanguage
WHERE language = 'French' AND percentage > 20);

