INSERT INTO User(userId,emailAddress, failedLoginsAttemps, name, password, surname)  VALUES  (1,'victormiranda',1,'victor','paco','miranda'),(2,'pacopaco',1,'paco','paco','miranda'),(3,'sheila',1,'sheila','paco','miranda');

INSERT INTO UserPreferences(userPreferenceId,userId, muteNotifications) VALUES (1,1,false),  (2,2,false);

INSERT INTO Dashboard(dashboardId,name, createUserId) VALUES  (1,'My dash', 1);

INSERT INTO User_Dashboard(userId, dashboardId) VALUES  (1,1),  (2,1);

INSERT INTO Status(statusId, createDate, modifiedDate, name, position, createUserId, dashboardId) VALUES (1,now(),now(),'Backlog',1,1,1),  (2,now(),now(),'Work in progress',2,1,1),  (3,now(),now(),'Ready to test',3,1,1),  (4,now(),now(),'Done',4,1,1);

INSERT INTO Ticket(ticketId, createDate, description, dueDate, locked, modifiedDate, title, createUserId,dashboardId, statusId) VALUES (1,now(),'Ticket1 Description',null,false,now(),'Title 1',1,1,2);

INSERT INTO Category(categoryId, createDate, modifiedDate, name, createUserId, dashboardId) VALUES  (1,now(),now(),'Analysis',1,1);

INSERT INTO Category_Ticket(ticketId, categoryId) VALUES (1,1);