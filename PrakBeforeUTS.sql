-- 1
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

-- 2
SELECT Code, Name, Population
FROM country
WHERE Population = 
(SELECT MAX(Population) as POPULASI_TERTINGGI
FROM country)
LIMIT 1;

-- 3
SELECT
 Code,
 Name,
 Continent,
 Population
FROM country
WHERE Continent = (
 SELECT Continent
 FROM country
 WHERE Name = 'Indonesia'
);

-- 4
SELECT
 ID,
 Name,
 CountryCode,
 District,
 Population
FROM city
WHERE CountryCode IN (
 SELECT Code
 FROM country
 WHERE Continent = 'Asia'
)
ORDER BY Population DESC;

-- 5
SELECT
 Code,
 Name
FROM country
WHERE Code NOT IN (
 SELECT CountryCode
 FROM city
);

SELECT
 c.Code,
 c.Name
FROM country c
WHERE NOT EXISTS (
 SELECT 1
 FROM city ci
 WHERE ci.CountryCode = c.Code
);

-- 6
SELECT
 c.Name AS nama_kota,
 c.CountryCode,
 c.Population
FROM city c
WHERE c.Population > (
 SELECT AVG(c2.Population)
 FROM city c2
 WHERE c2.CountryCode = c.CountryCode
)
ORDER BY c.CountryCode, c.Population DESC;

-- 7
SELECT
 Code,
 Name
FROM country
WHERE EXISTS (
 SELECT 1
 FROM countrylanguage cl
 WHERE cl.CountryCode = country.Code
 AND cl.IsOfficial = 'T'
)
ORDER BY Name;

-- 8 
SELECT
 CountryCode,
 Language,
 IsOfficial,
 Percentage
FROM countrylanguage
WHERE Percentage > (
 SELECT AVG(Percentage)
 FROM countrylanguage
)
ORDER BY Percentage DESC;

-- 9
SELECT
 c.Name AS nama_kota,
 c.CountryCode,
 c.Population
FROM city c
WHERE c.Population = (
 SELECT MAX(c2.Population)
 FROM city c2
 WHERE c2.CountryCode = c.CountryCode
)
ORDER BY c.CountryCode;

/*SOAL MANDIRI*/
-- 1. Tampilkan Code, Name, dan Population negara yang populasinya di atas rata-rata global. Gunakan AVG().
SELECT Code, Name, Population
FROM country
WHERE Population > (
 SELECT AVG(Population)
 FROM country
)
ORDER BY Population DESC;

-- 2.Tampilkan negara yang SurfaceArea-nya sama dengan nilai maksimum. Gunakan MAX().
SELECT *
FROM country
WHERE SurfaceArea = 
(SELECT MAX(SurfaceArea) 
FROM country);

-- 3. Tampilkan kota yang CountryCode-nya termasuk daftar negara dengan Population di atas 100 juta. Gunakan IN.
SELECT *
FROM city
WHERE CountryCode IN (
 SELECT Code
 FROM country
 WHERE Population >= 100000000
)
ORDER BY Population DESC;

-- 4. Tampilkan Code dan Name negara yang tidak memiliki kota pada tabel city. Gunakan NOT EXISTS.
SELECT c.Code, c.Name
FROM country c
WHERE NOT EXISTS (
 SELECT *
 FROM city ci
 WHERE ci.CountryCode = c.Code
);

-- 5. Tampilkan negara yang mempunyai setidaknya satu bahasa resmi. Gunakan EXISTS
SELECT c.Code, c.Name
FROM country
WHERE EXISTS (
 SELECT *
 FROM countrylanguage cl
 WHERE cl.CountryCode = c.Code
 AND cl.IsOfficial = 'T'
)
ORDER BY Name;

