# Java 
```
Banu Prakash C
Full Stack Architect, Corporate Trainer
Co-founder & CTO: Lucida Technologies Pvt Ltd.,
Email: banuprakashc@yahoo.co.in
banuprakash.cr@gmail.com
https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/VISA_JAVA

```

Softwares Required:

```
1) openJDK 21 https://jdk.java.net/java-se-ri/21
Option 1: install and add path and JAVA_HOME
vi ~/.zshrc export JAVA_HOME=/Users/banuprakash/Desktop/jdk-21
export PATH="/Users/banuprakash/Desktop/jdk-21/bin:"$PATH

Option 2: [better]
USE SDKMAN to manage java
curl -s "https://get.sdkman.io" | bash
sdk install java 21.0.6-tem
sdk default java 21.0.6-tem

https://mydeveloperplanet.com/2022/04/05/how-to-manage-your-jdks-with-sdkman/#:~:text=Some%20time%20ago%2C%20a%20colleague%20of%20mine,maintain%20different%20versions%20of%20JDKs%2C%20Maven%2C%20etc.

$ java --version

2) IntelliJ Ultimate or Community edition https://www.jetbrains.com/idea/download/?section=mac

3) MySQL [ Prefer on Docker]
Install Docker Desktop
Docker steps:
a) docker pull mysql
b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql
container name given here is "local-mysql"
For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

c) CONNECT TO A MYSQL RUNNING CONTAINER:
$ docker exec -t -i local-mysql bash

d) Run MySQL client:
bash terminal> mysql -u "root" -p
mysql> exit

```
OOP: Object Oriented Paradigm
* Real world
Object - state and behaviour/actions

Template - class , function , type

SOLID design principles:
SRP --> Single Reposibility

OCP -> Open for extension and Closed for Change.

L -> Liskov Substitution Principle

I -> Interface seggregation

D -> Dependency Injection (Inversion Of Control)

=======================

What is Java?
Technology
Platform - for executing bytecode [portable]

Java Language -- javac - bytecode
Kotlin -- Kotlin Compiler -- bytecode
Groovy --> Groovy Compiler -- bytecode

Account.java
javac Account.java ===> Account.class
```
    public class Account {
        private double balance; // state, instance variables

        // instance methods, actions, behaviours
        public void deposit(double amt) {
            balance += amt;
        }

        public void withdraw(double amt) {
            this.balance -= amt;
        }

        public double getBalance() {
            return this.balance;
        }
    }

```

AccountExample.java
javac AccountExample -> AccountExample.class
```
    public class AccountExample {
        public static void main(String[] args) {
            Account swethaAcc = new Account(); // instances, Objects
            Account riaAcc = new Account();
            
            swethaAcc.deposit(5000);

            System.out.println(swethaAcc.getBalance());
        }
    }

```

Java RuntimeEnvironment [ target ]

java AccountExample 

ClassLoader: 
    Loads the .class file from Secondary to Primary Storage
    folder where you are executing, CLASSPATH env variable
    1) findLoadedClass()
    2) loadClass()
    3) defineClass()

    2a) findSystemClass() --> defineClass()
    

METASPACE

===========================

* instance variables / state ==> HEAP area
* instance methods ==> any methods executed on Stack
* local variables ==> stack

Any variables if memory is allocated on METASPACE / HEAP area will have default values
Variables on Stack won't have default values, you need to initialize before using.

==============================

Libraries --> jar [ Java Archive ], war --> Web Archive, EAR --> Enterprise archive

Logically grouping of classes / objects
1) Entity / Model / Domain classes
    -> Generally assocaited with a persistent store [ like database , files]
    -> state
    -> getters and setters
    -> constructor
    -> equals() and hashCode()
2) DAO Data Access Objects
    CODE to interact with persistent layer
3) Business Layer
4) Utility: Helpers
5) Exception classes
6) Service: facade over DAO and Business layer
```
BankingService
    void transferFunds(Account fromAcc, Account toAcc, double amt){
        // SELECT balance ->DAO
        // update fromAcc -> DAO 
        // update toACC --> DAO
        // INSERT to Tx table --> DAO
        // send SMS
        // Send EMAIL
    }

```
7) UI / Client


packages --> folders for logically grouping

```
package com.visa.project.entity
public class Employee {
    
}

    com
     |
     visa
        |
        project / module
            |
            entity
                ... classes
            dao
                ...classes
            service
                ...classes
    ...
```

Relationship between objects.
1) Generalization and Specialziation
2) Realization
3) Association [ Composition or Aggregation]
4) Uses A

Bad Code:
```
    class Tv {
        id,
        name,
        price,
        screenSize,
        screenType
        getters / setters
    }

    class Mobile {
         id,
        name,
        price,
        camera,
        connectivity,
        memory
    }

```

Modify:
```
How Constructors are chained
class Product {
    Product() {
        "P1"
    }

    Product(id, name) {
        "P2"
    }
}

    class Mobile {
        Mobile(){
            "M1"
        }

        Mobile(id, name, price, connect) {
            super(id, name);
            "M2"
        }
    }

    new Mobile(); // P1, M1
    new Mobile(24, "iPhone", 89000.00, "5G"); // P1, M2 to // P2, M2
```

How Methods work?

```
    class Product {
        getPrice() {
            return 100;
        }
    }

    class Mobile extends Product {
        getPrice() {
            return 500;
        }

        getConnectivity() {
            return "5G"
        }
    }

    Mobile m = new Mobile();
    m.getPrice(); // 500
    m.getConnectivity(); // 5G

    Product p = new Mobile();
    p.getPrice(); // 500
    p.getConnectivity(); // ERROR

```

Day 2:

Visibility: 
1) private --> within class
2) default -> within class, other classes within same package
3) protected -> within class, other classes within same package, other inherited classes even if present outside package
4) public 

Override, reflection API.

================================
Realization relationship:

Represents a contract fulfillment where a class provides the implementation for methods declared in an interface.

"implements" connection between two model elements, where a classifier (like a class) fulfills the contract or behaviors defined by another (like an interface or component).

Java provides interface for realization relationship.

interface InterfaceName {
    abstract methods()
    can have constants
    can't have state
}

Why program to interface?
1) DESIGN
2) IMPLMENTATION
3) INTEGRATION
4) TESTING
5) LOOSE COUPLING
6) OCP

```
    interface Swim {
        swim();
    }

    interface Dance {
        dance()
    }

    interface Fight {
        fight();
    }

    public class Actor implements Dance {
        public void dance() {

        }
    }

    public class Hero extends Actor implements Fight, Swim {
        fight() {}
        swim() {}
    }

    Fight f = new Hero();
    f.fight();
    f.dance(); // error

    Swim s = (Swim) f;
    s.swim(); // works

    Dance d = (Dance) s;
    d.dance();

---

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    // state
    // behaviour
    public void fly() {

    }
}

class AeroPlane implements Flyable {
    // state
    // behaiour
     public void fly() {

    }
}

class FlyAttempt implements Flyable {
     public void fly() {
        jump from 4th Floor
    }
}

Flyable f = new Flyable() {
     public void fly() {
        jump from 4th Floor
    }
}

f.fight();

// Unit of Work - Thread
interface Runnable {
    void run();
}

public class WorkerThread implements Runnable {
    //
    public void run() {
        //
    }
}

new Thread(new WorkerThread()).start();

new Thread(new Runnable(){
    public void run() {
        while(true) {
            Thread.sleep(1000);
            sout(Date.now());
        }
    }
})
```


