# MidtermProject

## Roles
Cody: The official Rumbler Scrum Master (aka OG Rumbler)
Maggie: The DBA (aka the creator of Jackie Chan)
Chai: The repo owner (aka dm slider)

## Overview
The purpose of the following app is to allow people that are interested in martial arts to find sparring partners. Here the user will be able to create an account or log in to their account, if already created. If a user decides to create an account, they will be prompted to input a new username and password as well as personal details about themselves. Once on the account page, users can add, edit, and delete disciplines as well as their personal account details. They will also be able to access their past and present sparring meet ups (Rumbles). When accessing rumbles, users can view all details about the meet up, including their partner and direct messages between the participants. Moreover, users can edit rumble details, direct messages, or even delete the rumble. 
	
Additionally, users are able to search for other Rumblers (other users) by name/username, zipcode, or  fighting disciplines and create a new rumble. When creating a rumble with another Rumbler, the user will be prompted to input details about the event, of which, may be updated later. 

The user is able to access a page of all sparring locations (rumble rings), and can click on a single rumble ring to view more details as well as reviews left by rumblers. If the user hasn't left a review themselves, they able to do so here. The user can also update the location if the user locates an error within the details.

The admin has access to the Admin-Dashboard which allows users with admin privileges to enable or disable any user created data with a click of a button.

## Technologies Used
Git/Github
SpringToolSuite4/Spring/Spring Boot
HTML/JSP
Bootstrap/CSS
MAMP
MySQL/MySQL Workbench
Gradle/Hibernate/JPA
Java
Canva
HttpSession
Discord

## Lessons Learned
- Composite keys are hard
We learned how to map composite keys appropriately and persist in JPA. composite keys add a new level of difficulty when communicating data between the front end and the back end.
- JSP don't communicate full on entities
When working with an entity with a child entity, in order to pass the data of the child entity, the form must contain all the required fields of the child entity.
- Session VS Model
With a session, the attribute must be updated or else the data will be stale. With a model, the attribute only gets sent to the following jsp (html view). Also learning when an attribute is used throughout the duration of the users session, it's important to refresh the session user to account for lazy loading and new changes persisted via JPA.
