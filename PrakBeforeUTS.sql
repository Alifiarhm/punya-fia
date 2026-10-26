SELECT AVG(Population) AS rata_rata_populasi
FROM country;

SELECT
 Code,
 Name,
 Population
FROM country
WHERE Population > (
 SELECT AVG(Population)
 FROM country
)
ORDER BY Population DESC;

SELECT Code, Name, Population
FROM country
WHERE Population = 
(SELECT MAX(Population) as POPULASI_TERTINGGI
FROM country)
LIMIT 1;

select *
from countrylanguage cl
where cl.isOfficial = 'T';

select c.Code, cl.language, language, cl.IsOfficial
from Country c
left join CountryLanguage cl
on cl.CountryCode = c.Code
where exists 
(select 1 
from CountryLanguage cl2
where cl2.IsOfficial = 'T'