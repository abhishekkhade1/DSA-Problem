# Write your MySQL query statement below
select Person.firstName, Person.lastName, Address.city, Address.state
From Person
Left Join Address
On Person.personId = Address.personId;
