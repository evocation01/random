-- Industry Type Table (Existing)
CREATE TABLE Industry_Type (
    Industry_ID INT PRIMARY KEY,
    Industry_Name VARCHAR(100) NOT NULL
);

-- Technopark Table (Existing)
CREATE TABLE Technopark (
    Technopark_ID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Location VARCHAR(255),
    Area DECIMAL(10, 2), -- In square meters
    Industry_Focus VARCHAR(100),
    Status VARCHAR(50),
    Budget DECIMAL(15, 2),
    Creation_Date DATE NOT NULL,
    Facilities TEXT,
    Security_Level VARCHAR(50)
);

-- Company Table (Existing)
CREATE TABLE Company (
    Company_ID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Industry VARCHAR(100),
    Technopark_ID INT,
    Revenue DECIMAL(15, 2),
    Number_of_Employees INT,
    CEO VARCHAR(100),
    Contact_Info VARCHAR(255),
    Industry_Type_ID INT,
    FOREIGN KEY (Technopark_ID) REFERENCES Technopark(Technopark_ID),
    FOREIGN KEY (Industry_Type_ID) REFERENCES Industry_Type(Industry_ID)
);

-- Employee Table (Existing)
CREATE TABLE Employee (
    Employee_ID INT PRIMARY KEY,
    First_Name VARCHAR(100) NOT NULL,
    Last_Name VARCHAR(100),
    Company_ID INT NOT NULL,
    Position VARCHAR(100),
    Hire_Date DATE NOT NULL,
    Salary DECIMAL(15, 2),
    FOREIGN KEY (Company_ID) REFERENCES Company(Company_ID)
);

-- Research Project Table (Existing)
CREATE TABLE Research_Project (
    Project_ID INT PRIMARY KEY,
    Title VARCHAR(100) NOT NULL,
    Technopark_ID INT NOT NULL,
    Start_Date DATE NOT NULL,
    End_Date DATE,
    Budget DECIMAL(15, 2),
    Status VARCHAR(50),
    Description TEXT,
    FOREIGN KEY (Technopark_ID) REFERENCES Technopark(Technopark_ID)
);

-- Event Type Table (Existing)
CREATE TABLE Event_Type (
    Event_Type_ID INT PRIMARY KEY,
    Event_Type_Name VARCHAR(100) NOT NULL
);

-- Event Table (Existing)
CREATE TABLE Event (
    Event_ID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Technopark_ID INT NOT NULL,
    Event_Date DATE NOT NULL,
    Location VARCHAR(255),
    Event_Type_ID INT NOT NULL,
    FOREIGN KEY (Technopark_ID) REFERENCES Technopark(Technopark_ID),
    FOREIGN KEY (Event_Type_ID) REFERENCES Event_Type(Event_Type_ID)
);

-- Investment Table (Existing)
CREATE TABLE Investment (
    Investment_ID INT PRIMARY KEY,
    Technopark_ID INT NOT NULL,
    Amount DECIMAL(15, 2) NOT NULL,
    Investor_Name VARCHAR(100),
    Investment_Date DATE NOT NULL,
    FOREIGN KEY (Technopark_ID) REFERENCES Technopark(Technopark_ID)
);

-- New Entities

-- Office Type Table
CREATE TABLE Office_Type (
    Office_Type_ID INT PRIMARY KEY,
    Type_Name VARCHAR(100) NOT NULL,
    Description TEXT
);

-- Office Table
CREATE TABLE Office (
    Office_ID INT PRIMARY KEY,
    Technopark_ID INT NOT NULL,
    Office_Type_ID INT NOT NULL,
    Area DECIMAL(10, 2) NOT NULL, -- In square meters
    Floor INT NOT NULL,
    Availability_Status VARCHAR(50) NOT NULL, -- e.g., vacant, occupied
    FOREIGN KEY (Technopark_ID) REFERENCES Technopark(Technopark_ID),
    FOREIGN KEY (Office_Type_ID) REFERENCES Office_Type(Office_Type_ID)
);

-- Rental Table
CREATE TABLE Rental (
    Rental_ID INT PRIMARY KEY,
    Technopark_ID INT NOT NULL,
    Company_ID INT NOT NULL,
    Office_ID INT NOT NULL,
    Start_Date DATE NOT NULL,
    End_Date DATE,
    Rental_Amount DECIMAL(15, 2) NOT NULL,
    Status VARCHAR(50) NOT NULL, -- e.g., active, terminated
    FOREIGN KEY (Technopark_ID) REFERENCES Technopark(Technopark_ID),
    FOREIGN KEY (Company_ID) REFERENCES Company(Company_ID),
    FOREIGN KEY (Office_ID) REFERENCES Office(Office_ID)
);

-- Partnership Table
CREATE TABLE Partnership (
    Partnership_ID INT PRIMARY KEY,
    Company_1_ID INT NOT NULL,
    Company_2_ID INT NOT NULL,
    Start_Date DATE NOT NULL,
    End_Date DATE,
    Partnership_Type VARCHAR(50), -- e.g., strategic, joint venture
    Details TEXT,
    FOREIGN KEY (Company_1_ID) REFERENCES Company(Company_ID),
    FOREIGN KEY (Company_2_ID) REFERENCES Company(Company_ID)
);

-- Usage Table
CREATE TABLE Usage (
    Usage_ID INT PRIMARY KEY,
    Technopark_ID INT NOT NULL,
    Facility_Name VARCHAR(100) NOT NULL,
    Company_ID INT,
    Event_ID INT,
    Usage_Date DATE NOT NULL,
    Duration DECIMAL(5, 2) NOT NULL, -- In hours
    Cost DECIMAL(10, 2),
    FOREIGN KEY (Technopark_ID) REFERENCES Technopark(Technopark_ID),
    FOREIGN KEY (Company_ID) REFERENCES Company(Company_ID),
    FOREIGN KEY (Event_ID) REFERENCES Event(Event_ID)
);
